// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routes
// @HASH:1f124834843d709feba2747cf62a07cc4c597ae1
// @DATE:Tue Oct 04 11:43:29 ART 2022

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:1052
// @LINE:1042
// @LINE:1025
// @LINE:494
// @LINE:493
// @LINE:492
// @LINE:491
// @LINE:490
// @LINE:489
// @LINE:488
// @LINE:487
// @LINE:486
// @LINE:485
// @LINE:484
// @LINE:482
// @LINE:481
// @LINE:480
// @LINE:479
// @LINE:478
// @LINE:477
// @LINE:476
// @LINE:474
// @LINE:473
// @LINE:472
// @LINE:471
// @LINE:470
// @LINE:469
// @LINE:467
// @LINE:466
// @LINE:465
// @LINE:464
// @LINE:463
// @LINE:462
// @LINE:460
// @LINE:459
// @LINE:458
// @LINE:457
// @LINE:456
// @LINE:455
// @LINE:454
// @LINE:453
// @LINE:452
// @LINE:451
// @LINE:450
// @LINE:449
// @LINE:448
// @LINE:447
// @LINE:446
// @LINE:445
// @LINE:444
// @LINE:443
// @LINE:442
// @LINE:441
// @LINE:439
// @LINE:438
// @LINE:437
// @LINE:436
// @LINE:435
// @LINE:434
// @LINE:433
// @LINE:432
// @LINE:431
// @LINE:430
package controllers.expediente {

// @LINE:1052
// @LINE:1042
// @LINE:460
// @LINE:459
// @LINE:458
// @LINE:457
// @LINE:456
// @LINE:455
// @LINE:454
// @LINE:453
// @LINE:452
// @LINE:451
// @LINE:450
// @LINE:449
// @LINE:448
// @LINE:447
// @LINE:446
// @LINE:445
// @LINE:444
// @LINE:443
// @LINE:442
// @LINE:441
class ReverseExpedientesController {
    

// @LINE:449
def modalBuscarCopia(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/modalBuscarCopia")
}
                                                

// @LINE:453
def reporteTapaExpediente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/reporteTapaExpediente" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:452
def reporteTapaExpedienteMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/reporteTapaExpedienteMasiva")
}
                                                

// @LINE:444
def editarExpediente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1052
def suggestExpedienteCopia(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestExpedienteCopia/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:442
def crearExpediente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/crear")
}
                                                

// @LINE:455
def crearCopia(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/crearCopia" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:450
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:451
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:454
def listadoExpedientes(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/reporteListadoExpedientes")
}
                                                

// @LINE:459
def getExpedientesSinFirma(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/getExpedientesSinFirma")
}
                                                

// @LINE:1042
def suggestExpediente(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestExpediente/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:458
def getExpedientesRecepcionSinFirmaReporte(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/getExpedientesRecepcionSinFirmaReporte")
}
                                                

// @LINE:448
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/modalBuscar")
}
                                                

// @LINE:443
def guardarExpediente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/expediente/guardar")
}
                                                

// @LINE:445
def eliminarExpediente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:457
def getExpedientesRecepcionSinFirma(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/getExpedientesRecepcionSinFirma")
}
                                                

// @LINE:447
def actualizarExpediente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/expediente/actualizar")
}
                                                

// @LINE:456
def crearRP(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/crearRP" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:460
def getExpedientesSinFirmaReporte(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/getExpedientesSinFirmaReporte")
}
                                                

// @LINE:441
def indexExpediente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente")
}
                                                

// @LINE:446
def eliminarExpedienteCopia(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expediente/eliminarCopia" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:494
// @LINE:493
// @LINE:492
// @LINE:491
// @LINE:490
// @LINE:489
// @LINE:488
// @LINE:487
// @LINE:486
// @LINE:485
// @LINE:484
class ReverseDisposController {
    

// @LINE:493
def getDisposPorExpediente(expedienteId:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo/getDisposPorExpediente" + queryString(List(if(expedienteId == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("expedienteId", expedienteId)))))
}
                                                

// @LINE:494
def cambiarEstado(idDispo:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idDispo", idDispo)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:485
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo/crear")
}
                                                

// @LINE:492
def getLastNumeroDispoByOrden(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/dispo/getLastNumeroDispoByOrden")
}
                                                

// @LINE:490
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:489
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:491
def getLastNumeroDispo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/dispo/getLastNumeroDispo")
}
                                                

// @LINE:486
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/dispo/guardar")
}
                                                

// @LINE:488
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/dispo/actualizar")
}
                                                

// @LINE:487
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:484
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/dispo")
}
                                                
    
}
                          

// @LINE:1025
// @LINE:438
// @LINE:437
// @LINE:436
// @LINE:435
// @LINE:434
// @LINE:433
// @LINE:432
// @LINE:431
class ReverseIniciadorExpedientesController {
    

// @LINE:435
def eliminarIniciadorExpediente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expedient/iniciadorExpediente/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:436
def actualizarIniciadorExpediente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente/actualizar")
}
                                                

// @LINE:1025
def suggestIniciadorExpediente(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestIniciador/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:438
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:433
def guardarIniciadorExpediente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente/guardar")
}
                                                

// @LINE:432
def crearIniciadorExpediente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente/crear")
}
                                                

// @LINE:437
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente/modalBuscar")
}
                                                

// @LINE:434
def editarIniciadorExpediente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:431
def indexIniciadorExpediente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/iniciadorExpediente")
}
                                                
    
}
                          

// @LINE:430
class ReverseIndexController {
    

// @LINE:430
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente")
}
                                                
    
}
                          

// @LINE:467
// @LINE:466
// @LINE:465
// @LINE:464
// @LINE:463
// @LINE:462
class ReverseExpedientesMovimientosController {
    

// @LINE:462
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/movimiento-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:467
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/movimiento-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:465
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/movimiento-linea/guardar")
}
                                                

// @LINE:466
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/movimiento-linea/actualizar")
}
                                                

// @LINE:464
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/movimiento-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:463
def crear(expedienteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/movimiento-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("expedienteId", expedienteId)))))
}
                                                
    
}
                          

// @LINE:476
// @LINE:474
// @LINE:473
// @LINE:472
// @LINE:439
class ReverseExpedientesReportesController {
    

// @LINE:476
def reportePaseExpedienteLista(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/reportes/reportePaseExpedienteLista")
}
                                                

// @LINE:472
def reportePaseExpediente(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/reportes/reportePaseExpediente" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:439
def reporteMovimiento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/reportes/reporteMovimiento")
}
                                                

// @LINE:474
def reportePaseExpedienteListaCodigo(codigo:Int): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/reportes/reportePaseExpedienteCodigo" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("codigo", codigo)))))
}
                                                

// @LINE:473
def reportePaseExpedienteListaCodigoCombinado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/reportes/reportePaseExpedienteLista")
}
                                                
    
}
                          

// @LINE:480
class ReverseExpedientesMisPasesController {
    

// @LINE:480
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/expedienteMisPases")
}
                                                
    
}
                          

// @LINE:482
// @LINE:481
// @LINE:479
// @LINE:478
// @LINE:477
// @LINE:471
// @LINE:470
// @LINE:469
class ReverseExpedientesAccionesController {
    

// @LINE:477
def cancelarPase(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/acciones/cancelarPase" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:470
def modalPasarOtroServicioIndividual(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/acciones/modalPasarOtroServicioIndividual" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:479
def asignarMiServicio(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/acciones/asignarMiServicio" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:471
def pasarOtroServicio(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/acciones/pasarOtroServicio")
}
                                                

// @LINE:478
def cancelarPaseLista(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/acciones/cancelarPaseLista")
}
                                                

// @LINE:469
def modalPasarOtroServicio(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/acciones/modalPasarOtroServicio")
}
                                                

// @LINE:482
def modalAsignarMiServicio(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "expediente/acciones/modalAsignarMiServicio")
}
                                                

// @LINE:481
def asignarAMiServicioMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "expediente/acciones/asignarMiServicioMasivo")
}
                                                
    
}
                          
}
                  

// @LINE:729
// @LINE:728
// @LINE:726
// @LINE:725
// @LINE:722
// @LINE:721
// @LINE:720
// @LINE:718
// @LINE:716
// @LINE:715
// @LINE:714
// @LINE:713
// @LINE:711
// @LINE:710
// @LINE:709
// @LINE:708
// @LINE:707
// @LINE:706
// @LINE:705
// @LINE:704
// @LINE:703
// @LINE:702
// @LINE:701
// @LINE:700
// @LINE:699
// @LINE:698
// @LINE:697
// @LINE:695
// @LINE:693
// @LINE:691
// @LINE:690
// @LINE:689
// @LINE:687
// @LINE:686
// @LINE:685
// @LINE:684
// @LINE:683
// @LINE:682
// @LINE:681
package controllers.presupuesto {

// @LINE:709
// @LINE:708
// @LINE:707
// @LINE:706
// @LINE:705
// @LINE:704
class ReverseLineasRecursosPresupuestariosController {
    

// @LINE:704
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-recurso/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:709
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-recurso/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:707
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/linea-recurso/guardar")
}
                                                

// @LINE:708
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/linea-recurso/actualizar")
}
                                                

// @LINE:706
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-recurso/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:705
def crear(creditoPresupuestarioId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-recurso/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("creditoPresupuestarioId", creditoPresupuestarioId)))))
}
                                                
    
}
                          

// @LINE:703
// @LINE:702
// @LINE:701
// @LINE:700
// @LINE:699
// @LINE:698
class ReverseLineasCreditosPresupuestariosController {
    

// @LINE:698
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-credito/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:703
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-credito/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:701
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/linea-credito/guardar")
}
                                                

// @LINE:702
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/linea-credito/actualizar")
}
                                                

// @LINE:700
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-credito/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:699
def crear(creditoPresupuestarioId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/linea-credito/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("creditoPresupuestarioId", creditoPresupuestarioId)))))
}
                                                
    
}
                          

// @LINE:711
// @LINE:710
class ReverseBalancePresupuestarioController {
    

// @LINE:711
def balancePresupuestarioPorExpediente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/balancePresupuestarioPorExpediente")
}
                                                

// @LINE:710
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/balance-presupuestario")
}
                                                
    
}
                          

// @LINE:697
// @LINE:695
// @LINE:693
// @LINE:691
// @LINE:690
// @LINE:689
// @LINE:687
// @LINE:686
// @LINE:685
// @LINE:684
// @LINE:683
// @LINE:682
class ReverseCreditosPresupuestariosController {
    

// @LINE:691
def aprobar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/aprobar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:693
def listaCargas(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-listaCargas")
}
                                                

// @LINE:683
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/crear")
}
                                                

// @LINE:689
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:690
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:686
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:684
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/guardar")
}
                                                

// @LINE:687
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/actualizar")
}
                                                

// @LINE:685
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:697
def reporteListadoCreditos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario/reporteListadoCreditos")
}
                                                

// @LINE:695
// @LINE:682
def index(): Call = {
   () match {
// @LINE:682
case () if true => Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario")
                                                        
// @LINE:695
case () if true => Call("GET", _prefix + { _defaultPrefix } + "presupuesto/credito-presupuestario")
                                                        
   }
}
                                                
    
}
                          

// @LINE:681
class ReverseIndexController {
    

// @LINE:681
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto")
}
                                                
    
}
                          

// @LINE:729
// @LINE:728
// @LINE:726
// @LINE:725
class ReverseControlPresupuestarioController {
    

// @LINE:729
def movimientosSaldoPreventivoExcel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/movimientosSaldoPreventivoExcel")
}
                                                

// @LINE:728
def movimientosSaldoPreventivo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/movimientosSaldoPreventivo")
}
                                                

// @LINE:726
def controlAnulacionProductosAutomaticosExcel(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/controlAnulacionProductosAutomaticosExcel")
}
                                                

// @LINE:725
def controlAnulacionProductosAutomaticos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/controlAnulacionProductosAutomaticos")
}
                                                
    
}
                          

// @LINE:722
// @LINE:721
// @LINE:720
// @LINE:718
// @LINE:716
// @LINE:715
// @LINE:714
// @LINE:713
class ReverseBalancePresupuestarioReportesController {
    

// @LINE:715
def modalReporteExportarDatosPresupuestoControl(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/reporte/modalReporteExportarDatosPresupuestoControl")
}
                                                

// @LINE:718
def reporteBalanceDiferenciaPreventivoDefinitivo(idEjercicio:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/reporte/reporteBalanceDiferenciaPreventivoDefinitivo" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idEjercicio", idEjercicio)))))
}
                                                

// @LINE:716
def reporteExportarDatosPresupuestoControl(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/reporte/reporteExportarDatosPresupuestoControl")
}
                                                

// @LINE:713
def modalReporteBalancePorCuentaPorExpediente(id:Integer = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/reporte/modalReporteBalancePorCuentaPorExpediente" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                                                

// @LINE:721
def reporteBalancePorFecha(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/reporteBalancePorFecha")
}
                                                

// @LINE:714
def reporteBalancePorCuentaPorExpediente(id:Integer = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/reporte/reporteBalancePorCuentaPorExpediente" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                                                

// @LINE:720
def modalReporteBalancePorFecha(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto/modalReporteBalancePorFecha")
}
                                                

// @LINE:722
def reporteBalancePorFechaPorExpediente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto/reporteBalancePorFechaPorExpediente")
}
                                                
    
}
                          
}
                  

// @LINE:1048
// @LINE:1047
// @LINE:1046
// @LINE:1018
// @LINE:1012
// @LINE:1010
// @LINE:1009
// @LINE:1008
// @LINE:1006
// @LINE:1005
// @LINE:1004
// @LINE:1003
// @LINE:1002
// @LINE:1001
// @LINE:1000
// @LINE:998
// @LINE:997
// @LINE:996
// @LINE:995
// @LINE:994
// @LINE:993
// @LINE:992
// @LINE:991
// @LINE:990
// @LINE:988
// @LINE:987
// @LINE:986
// @LINE:985
// @LINE:984
// @LINE:983
// @LINE:982
// @LINE:981
// @LINE:980
// @LINE:979
// @LINE:978
// @LINE:977
// @LINE:976
// @LINE:975
// @LINE:974
// @LINE:973
// @LINE:972
// @LINE:971
// @LINE:970
// @LINE:969
// @LINE:968
// @LINE:967
// @LINE:966
// @LINE:965
// @LINE:964
// @LINE:963
// @LINE:962
// @LINE:961
// @LINE:960
// @LINE:957
// @LINE:956
// @LINE:954
// @LINE:953
// @LINE:952
// @LINE:951
// @LINE:950
// @LINE:949
// @LINE:948
// @LINE:947
// @LINE:946
// @LINE:944
// @LINE:943
// @LINE:942
// @LINE:941
// @LINE:940
// @LINE:939
// @LINE:938
// @LINE:937
// @LINE:936
// @LINE:934
// @LINE:933
// @LINE:932
// @LINE:931
// @LINE:930
// @LINE:929
// @LINE:928
// @LINE:927
// @LINE:926
// @LINE:924
// @LINE:923
// @LINE:922
// @LINE:921
// @LINE:920
// @LINE:919
// @LINE:918
// @LINE:917
// @LINE:916
// @LINE:915
// @LINE:913
// @LINE:912
// @LINE:911
// @LINE:910
// @LINE:909
// @LINE:908
// @LINE:907
// @LINE:906
// @LINE:905
// @LINE:903
// @LINE:902
// @LINE:901
// @LINE:900
// @LINE:899
// @LINE:898
// @LINE:897
// @LINE:896
// @LINE:895
// @LINE:893
// @LINE:892
// @LINE:891
// @LINE:890
// @LINE:889
// @LINE:888
// @LINE:886
// @LINE:885
// @LINE:884
// @LINE:883
// @LINE:882
// @LINE:881
// @LINE:880
// @LINE:879
// @LINE:878
// @LINE:877
// @LINE:875
// @LINE:874
// @LINE:872
// @LINE:871
// @LINE:870
// @LINE:869
// @LINE:868
// @LINE:867
// @LINE:866
// @LINE:865
// @LINE:864
// @LINE:863
// @LINE:862
// @LINE:861
// @LINE:860
// @LINE:859
// @LINE:858
// @LINE:856
// @LINE:855
// @LINE:854
// @LINE:853
// @LINE:852
// @LINE:851
// @LINE:850
// @LINE:849
// @LINE:848
// @LINE:847
// @LINE:845
// @LINE:844
// @LINE:843
// @LINE:842
// @LINE:841
// @LINE:840
// @LINE:839
// @LINE:838
// @LINE:837
// @LINE:835
// @LINE:834
// @LINE:833
// @LINE:832
// @LINE:831
// @LINE:830
// @LINE:829
// @LINE:828
// @LINE:827
// @LINE:825
// @LINE:824
// @LINE:823
// @LINE:822
// @LINE:821
// @LINE:820
// @LINE:819
// @LINE:818
// @LINE:817
// @LINE:815
// @LINE:814
// @LINE:813
// @LINE:812
// @LINE:811
// @LINE:810
// @LINE:809
// @LINE:808
// @LINE:807
// @LINE:805
// @LINE:804
// @LINE:803
// @LINE:802
// @LINE:801
// @LINE:800
// @LINE:799
// @LINE:798
// @LINE:797
// @LINE:795
// @LINE:794
// @LINE:793
// @LINE:792
// @LINE:791
// @LINE:790
// @LINE:789
// @LINE:788
// @LINE:787
// @LINE:784
// @LINE:783
// @LINE:781
// @LINE:780
// @LINE:778
// @LINE:777
// @LINE:776
// @LINE:775
// @LINE:774
// @LINE:773
// @LINE:772
// @LINE:771
// @LINE:770
// @LINE:766
// @LINE:765
// @LINE:764
// @LINE:763
// @LINE:762
// @LINE:761
// @LINE:760
// @LINE:759
// @LINE:758
// @LINE:757
// @LINE:756
// @LINE:753
// @LINE:752
// @LINE:750
// @LINE:749
// @LINE:748
// @LINE:747
// @LINE:746
// @LINE:745
// @LINE:744
// @LINE:743
// @LINE:742
package controllers.haberes {

// @LINE:795
// @LINE:794
// @LINE:793
// @LINE:792
// @LINE:791
// @LINE:790
// @LINE:789
// @LINE:788
// @LINE:787
class ReversePuestosLaboralesReportesController {
    

// @LINE:788
def altasMacroSueldo(nuevo:Boolean = false): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/reportes/alta-macrosueldo" + queryString(List(if(nuevo == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("nuevo", nuevo)))))
}
                                                

// @LINE:795
def formulario6492022(id:Long, ejercicio_id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reportes/formulario649-2022" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Int]].unbind("ejercicio_id", ejercicio_id)))))
}
                                                

// @LINE:790
def listadoPuestosLaborales(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/reportes/listado")
}
                                                

// @LINE:787
def altasMasivas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/reportes/alta-masiva")
}
                                                

// @LINE:792
def formulario649(id:Long, ejercicio_id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reportes/formulario649" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Int]].unbind("ejercicio_id", ejercicio_id)))))
}
                                                

// @LINE:794
def formulario6492021(id:Long, ejercicio_id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reportes/formulario649-2021" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Int]].unbind("ejercicio_id", ejercicio_id)))))
}
                                                

// @LINE:793
def formulario6492019(id:Long, ejercicio_id:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reportes/formulario649-2019" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Int]].unbind("ejercicio_id", ejercicio_id)))))
}
                                                

// @LINE:791
def reportef649(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/reportes/f649")
}
                                                

// @LINE:789
def descargarArchivo(url:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/reportes/descargar-archivo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                
    
}
                          

// @LINE:856
// @LINE:855
// @LINE:854
// @LINE:853
// @LINE:852
// @LINE:851
// @LINE:850
// @LINE:849
// @LINE:848
// @LINE:847
class ReverseCategoriasLaboralesController {
    

// @LINE:848
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/crear")
}
                                                

// @LINE:854
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:855
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:851
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:849
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/guardar")
}
                                                

// @LINE:852
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/actualizar")
}
                                                

// @LINE:853
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/modalBuscar")
}
                                                

// @LINE:856
def suggestCategoriaLaboral(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/suggestCategoriaLaboral/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:850
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:847
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/categoriaLaboral")
}
                                                
    
}
                          

// @LINE:954
// @LINE:953
// @LINE:952
// @LINE:951
// @LINE:950
// @LINE:949
// @LINE:948
// @LINE:947
// @LINE:946
class ReverseInstrumentosLegalesController {
    

// @LINE:947
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento/crear")
}
                                                

// @LINE:953
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:954
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:950
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:948
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/instrumento/guardar")
}
                                                

// @LINE:951
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/instrumento/actualizar")
}
                                                

// @LINE:952
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento/modalBuscar")
}
                                                

// @LINE:949
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:946
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/instrumento")
}
                                                
    
}
                          

// @LINE:1006
// @LINE:1005
// @LINE:1004
// @LINE:1003
// @LINE:1002
// @LINE:1001
// @LINE:1000
class ReverseEscalasLaboralesMontosController {
    

// @LINE:1001
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto/crear")
}
                                                

// @LINE:1006
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1004
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1002
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto/guardar")
}
                                                

// @LINE:1005
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto/actualizar")
}
                                                

// @LINE:1003
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1000
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboralMonto")
}
                                                
    
}
                          

// @LINE:872
// @LINE:870
// @LINE:866
// @LINE:865
// @LINE:864
// @LINE:863
// @LINE:862
// @LINE:861
// @LINE:860
// @LINE:859
// @LINE:858
class ReverseLiquidacionPuestosController {
    

// @LINE:870
def cambiarEstado(idLiquidacionPuesto:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idLiquidacionPuesto", idLiquidacionPuesto)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:859
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/crear")
}
                                                

// @LINE:872
def preLiquidar(idPuestoLaboral:Long, idLiquidacionMes:Long, idLiquidacionPuesto:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/preliquidar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idPuestoLaboral", idPuestoLaboral)), Some(implicitly[QueryStringBindable[Long]].unbind("idLiquidacionMes", idLiquidacionMes)), Some(implicitly[QueryStringBindable[Long]].unbind("idLiquidacionPuesto", idLiquidacionPuesto)))))
}
                                                

// @LINE:865
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:866
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:862
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:860
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/guardar")
}
                                                

// @LINE:863
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/actualizar")
}
                                                

// @LINE:864
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/modalBuscar")
}
                                                

// @LINE:861
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:858
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto")
}
                                                
    
}
                          

// @LINE:944
// @LINE:943
// @LINE:942
// @LINE:941
// @LINE:940
// @LINE:939
// @LINE:938
// @LINE:937
// @LINE:936
class ReverseLegajosController {
    

// @LINE:937
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo/crear")
}
                                                

// @LINE:943
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:944
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:940
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:938
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/legajo/guardar")
}
                                                

// @LINE:941
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/legajo/actualizar")
}
                                                

// @LINE:942
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo/modalBuscar")
}
                                                

// @LINE:939
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:936
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/legajo")
}
                                                
    
}
                          

// @LINE:825
// @LINE:824
// @LINE:823
// @LINE:822
// @LINE:821
// @LINE:820
// @LINE:819
// @LINE:818
// @LINE:817
class ReverseLiquidacionBaseCalculosController {
    

// @LINE:818
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/crear")
}
                                                

// @LINE:824
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:825
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:821
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:819
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/guardar")
}
                                                

// @LINE:822
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/actualizar")
}
                                                

// @LINE:823
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/modalBuscar")
}
                                                

// @LINE:820
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:817
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionBaseCalculo")
}
                                                
    
}
                          

// @LINE:934
// @LINE:933
// @LINE:932
// @LINE:931
// @LINE:930
// @LINE:929
// @LINE:928
// @LINE:927
// @LINE:926
class ReverseConveniosBancosController {
    

// @LINE:927
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco/crear")
}
                                                

// @LINE:933
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:934
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:930
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:928
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/convenioBanco/guardar")
}
                                                

// @LINE:931
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/convenioBanco/actualizar")
}
                                                

// @LINE:932
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco/modalBuscar")
}
                                                

// @LINE:929
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:926
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/convenioBanco")
}
                                                
    
}
                          

// @LINE:1046
// @LINE:805
// @LINE:804
// @LINE:803
// @LINE:802
// @LINE:801
// @LINE:800
// @LINE:799
// @LINE:798
// @LINE:797
class ReverseLiquidacionConceptosController {
    

// @LINE:798
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/crear")
}
                                                

// @LINE:804
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:805
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:801
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:799
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/guardar")
}
                                                

// @LINE:802
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/actualizar")
}
                                                

// @LINE:803
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/modalBuscar")
}
                                                

// @LINE:1046
def suggestLiquidacionConceptoTipo(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestConcepto/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:800
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:797
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConcepto")
}
                                                
    
}
                          

// @LINE:886
// @LINE:885
// @LINE:884
// @LINE:883
// @LINE:882
// @LINE:881
// @LINE:880
// @LINE:879
// @LINE:878
// @LINE:877
class ReverseLiquidacionPuestosAccionesController {
    

// @LINE:883
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/modalPasarBorrador")
}
                                                

// @LINE:881
def modalPasarPreaprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/modalPasarPreaprobado")
}
                                                

// @LINE:877
def modalPasarAOtraLiquidacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/modalPasarAOtraLiquidacion")
}
                                                

// @LINE:882
def pasarPreaprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/pasarPreaprobadoMasivo")
}
                                                

// @LINE:879
def modalPasarAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/modalPasarAprobado")
}
                                                

// @LINE:886
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/pasarCanceladoMasivo")
}
                                                

// @LINE:884
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/pasarBorradorMasivo")
}
                                                

// @LINE:885
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/modalPasarCancelado")
}
                                                

// @LINE:880
def pasarAprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/pasarEnCursoMasivo")
}
                                                

// @LINE:878
def pasarAOtraLiquidacion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/pasarAOtraLiquidacion")
}
                                                
    
}
                          

// @LINE:835
// @LINE:834
// @LINE:833
// @LINE:832
// @LINE:831
// @LINE:830
// @LINE:829
// @LINE:828
// @LINE:827
class ReverseLiquidacionTiposController {
    

// @LINE:828
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/crear")
}
                                                

// @LINE:834
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:835
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:831
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:829
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/guardar")
}
                                                

// @LINE:832
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/actualizar")
}
                                                

// @LINE:833
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/modalBuscar")
}
                                                

// @LINE:830
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:827
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionTipo")
}
                                                
    
}
                          

// @LINE:750
// @LINE:749
// @LINE:748
// @LINE:747
// @LINE:746
// @LINE:745
// @LINE:744
// @LINE:743
class ReverseNovedadesController {
    

// @LINE:746
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades/crear")
}
                                                

// @LINE:745
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:750
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:747
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/novedades/guardar")
}
                                                

// @LINE:749
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/novedades/actualizar")
}
                                                

// @LINE:744
def lista(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades/lista")
}
                                                

// @LINE:748
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:743
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades")
}
                                                
    
}
                          

// @LINE:903
// @LINE:902
// @LINE:901
// @LINE:900
// @LINE:899
// @LINE:898
// @LINE:897
// @LINE:896
// @LINE:895
class ReverseCargosLaboralesController {
    

// @LINE:896
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/crear")
}
                                                

// @LINE:902
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:903
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:899
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:897
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/guardar")
}
                                                

// @LINE:900
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/actualizar")
}
                                                

// @LINE:901
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/modalBuscar")
}
                                                

// @LINE:898
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:895
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/cargoLaboral")
}
                                                
    
}
                          

// @LINE:753
// @LINE:752
class ReverseNovedadesAccionesController {
    

// @LINE:752
def crearMasivo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/novedades/acciones/crear-masivo")
}
                                                

// @LINE:753
def procesarMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/novedades/acciones/procesar-masivo")
}
                                                
    
}
                          

// @LINE:845
// @LINE:844
// @LINE:843
// @LINE:842
// @LINE:841
// @LINE:840
// @LINE:839
// @LINE:838
// @LINE:837
class ReverseUnidadesLaboralesController {
    

// @LINE:838
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/crear")
}
                                                

// @LINE:844
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:845
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:841
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:839
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/guardar")
}
                                                

// @LINE:842
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/actualizar")
}
                                                

// @LINE:843
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/modalBuscar")
}
                                                

// @LINE:840
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:837
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/unidadLaboral")
}
                                                
    
}
                          

// @LINE:997
// @LINE:996
// @LINE:995
// @LINE:994
// @LINE:993
// @LINE:992
// @LINE:991
// @LINE:990
class ReverseLiquidacionAccionesController {
    

// @LINE:992
def exportBanco(liquidacionId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/exportBanco" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("liquidacionId", liquidacionId)))))
}
                                                

// @LINE:995
def descargarAfip(url:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/descargarAfip" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                

// @LINE:997
def descargarIps(url:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/descargarIps" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                

// @LINE:991
def exportMacroSueldos(liquidacionId:Long, nuevo:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/exportMacroSueldos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("liquidacionId", liquidacionId)), if(nuevo == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("nuevo", nuevo)))))
}
                                                

// @LINE:996
def exportIps(liquidacionId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/exportIps" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("liquidacionId", liquidacionId)))))
}
                                                

// @LINE:993
def descargarBanco(url:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/descargarBanco" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("url", url)))))
}
                                                

// @LINE:990
def exportMacroSueldosLista(nuevo:Boolean = false): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/exportMacroSueldosLista" + queryString(List(if(nuevo == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("nuevo", nuevo)))))
}
                                                

// @LINE:994
def exportAfip(liquidacionId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/exportAfip" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("liquidacionId", liquidacionId)))))
}
                                                
    
}
                          

// @LINE:1018
// @LINE:984
// @LINE:967
// @LINE:966
// @LINE:965
// @LINE:964
// @LINE:963
// @LINE:962
// @LINE:961
// @LINE:960
// @LINE:957
// @LINE:956
class ReverseLiquidacionMesesController {
    

// @LINE:984
def cambiarEstado(idLiquidacion:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idLiquidacion", idLiquidacion)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:957
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/crear")
}
                                                

// @LINE:965
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:967
def preliquidar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/preliquidar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:966
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:962
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:960
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/guardar")
}
                                                

// @LINE:963
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/actualizar")
}
                                                

// @LINE:964
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/modalBuscar")
}
                                                

// @LINE:1018
def suggestLiquidacionMes(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestLiquidacionMes/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:961
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:956
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes")
}
                                                
    
}
                          

// @LINE:1012
class ReversePrestaFacilController {
    

// @LINE:1012
def enviarArchivo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/prestaFacil/enviarArchivo")
}
                                                
    
}
                          

// @LINE:815
// @LINE:814
// @LINE:813
// @LINE:812
// @LINE:811
// @LINE:810
// @LINE:809
// @LINE:808
// @LINE:807
class ReverseLiquidacionConceptoTiposController {
    

// @LINE:808
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/crear")
}
                                                

// @LINE:814
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:815
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:811
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:809
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/guardar")
}
                                                

// @LINE:812
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/actualizar")
}
                                                

// @LINE:813
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/modalBuscar")
}
                                                

// @LINE:810
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:807
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionConceptoTipo")
}
                                                
    
}
                          

// @LINE:913
// @LINE:912
// @LINE:911
// @LINE:910
// @LINE:909
// @LINE:908
// @LINE:907
// @LINE:906
// @LINE:905
class ReverseCentrosCostosController {
    

// @LINE:906
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto/crear")
}
                                                

// @LINE:912
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:913
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:909
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:907
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/centroCosto/guardar")
}
                                                

// @LINE:910
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/centroCosto/actualizar")
}
                                                

// @LINE:911
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto/modalBuscar")
}
                                                

// @LINE:908
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:905
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/centroCosto")
}
                                                
    
}
                          

// @LINE:1048
// @LINE:1047
// @LINE:778
// @LINE:766
// @LINE:765
// @LINE:764
// @LINE:763
// @LINE:762
// @LINE:761
// @LINE:760
// @LINE:759
// @LINE:758
// @LINE:757
// @LINE:756
class ReversePuestosLaboralesController {
    

// @LINE:766
def cambiarEstado(idPuesto:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idPuesto", idPuesto)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:1048
def suggestPuestoLaboralTodos(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestPuestoLaboralTodos/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:757
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/crear")
}
                                                

// @LINE:764
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:763
def modalBuscarTodos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/modal-buscar-todos")
}
                                                

// @LINE:765
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:760
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborale/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:758
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/guardar")
}
                                                

// @LINE:761
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/actualizar")
}
                                                

// @LINE:1047
def suggestPuestoLaboral(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestPuestoLaboral/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:762
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/modal-buscar")
}
                                                

// @LINE:778
def liquidarCierre(idPuestoLaboral:Long, idLiquidacionMes:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/liquidarCierre" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idPuestoLaboral", idPuestoLaboral)), Some(implicitly[QueryStringBindable[Long]].unbind("idLiquidacionMes", idLiquidacionMes)))))
}
                                                

// @LINE:759
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:756
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales")
}
                                                
    
}
                          

// @LINE:875
// @LINE:874
// @LINE:871
// @LINE:869
// @LINE:868
// @LINE:867
class ReverseLiquidacionPuestosReportesController {
    

// @LINE:875
def enviarReciboPorMail(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/reportes/enviarReciboPorMail")
}
                                                

// @LINE:868
def reciboSueldo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/reportes/reciboSueldo")
}
                                                

// @LINE:874
def modalReciboSueldoPorPuestoMail(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/reportes/modalReciboSueldoPorPuestoMail" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:867
def reciboSueldoPorPuesto(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/reportes/reciboSueldoPorPuesto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:871
def libroSueldos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/reportes/libroSueldos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:869
def reciboSueldosByLiquidacionMes(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionPuesto/reportes/reciboSueldosByLiquidacionMes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:924
// @LINE:923
// @LINE:922
// @LINE:921
// @LINE:920
// @LINE:919
// @LINE:918
// @LINE:917
// @LINE:916
// @LINE:915
class ReverseEscalasLaboralesController {
    

// @LINE:916
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/crear")
}
                                                

// @LINE:922
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:923
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:919
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:917
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/guardar")
}
                                                

// @LINE:920
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/actualizar")
}
                                                

// @LINE:924
def suggestEscalaLaboral(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/suggestEscalaLaboral/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:921
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/modalBuscar")
}
                                                

// @LINE:918
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:915
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/escalaLaboral")
}
                                                
    
}
                          

// @LINE:1010
// @LINE:1009
// @LINE:1008
class ReverseGananciasAccionesController {
    

// @LINE:1010
def modalFormularioF649(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/gananciasAcciones/modalFormularioF649")
}
                                                

// @LINE:1008
def buscarDatosGananciasEnArchivos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/gananciasAcciones/buscarDatosGananciasEnArchivos")
}
                                                

// @LINE:1009
def modalBuscarDatosGananciasEnArchivos(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/gananciasAcciones/modalBuscarDatosGananciasEnArchivos")
}
                                                
    
}
                          

// @LINE:742
class ReverseIndexController {
    

// @LINE:742
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes")
}
                                                
    
}
                          

// @LINE:784
// @LINE:783
// @LINE:781
// @LINE:780
// @LINE:777
// @LINE:776
// @LINE:775
// @LINE:774
// @LINE:773
// @LINE:772
// @LINE:771
// @LINE:770
class ReversePuestosLaboralesAccionesController {
    

// @LINE:783
def modalPreliquidarFinalPuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/acciones/modalPreliquidarPuestoFinal")
}
                                                

// @LINE:773
def crearNovedadesBasicas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/crearNovedades")
}
                                                

// @LINE:771
def desactivar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/acciones/desactivar")
}
                                                

// @LINE:777
def pasarAControlado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/pasarAControlado")
}
                                                

// @LINE:775
def pasarABorrador(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/pasarABorrador")
}
                                                

// @LINE:780
def modalPreliquidarPuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/acciones/modalPreliquidarPuesto")
}
                                                

// @LINE:772
def modalCrearNovedades(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/acciones/modalCrearNovedades")
}
                                                

// @LINE:774
def modalPasarABorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/modalPasarABorrador")
}
                                                

// @LINE:776
def modalPasarAControlado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/modalPasarAControlado")
}
                                                

// @LINE:770
def activar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/acciones/activar")
}
                                                

// @LINE:781
def preliquidarPuesto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/preliquidarPuesto")
}
                                                

// @LINE:784
def preliquidarFinalPuesto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/puestos-laborales/preliquidarPuestoFinal")
}
                                                
    
}
                          

// @LINE:998
// @LINE:988
// @LINE:987
// @LINE:986
// @LINE:985
// @LINE:983
// @LINE:982
// @LINE:981
// @LINE:980
// @LINE:979
// @LINE:978
// @LINE:977
// @LINE:976
// @LINE:975
// @LINE:974
// @LINE:973
// @LINE:972
// @LINE:971
// @LINE:970
// @LINE:969
// @LINE:968
class ReverseLiquidacionMesesReportesController {
    

// @LINE:968
def totalPorConceptos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/totalPorConceptos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:978
def listadoDePuestoLaboral(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoDePuestoLaboral" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:973
def listadoObraSocial(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoObraSocial" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:980
def listadoDePuestoLaboralComparativoPeriodo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoDePuestoLaboralComparativoPeriodo" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:972
def listadoJubilacion(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoJubilacion" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:974
def datosGenerales(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/datosGenerales" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:988
def reportesControlDatosAfipGanancias(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/reportesControlDatosAfipGanancias")
}
                                                

// @LINE:987
def modalControlDatosAfipGanancias(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/modalControlDatosAfipGanancias")
}
                                                

// @LINE:975
def ordenDePago(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/ordenDePago" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:977
def listadoPorConceptosPorPuestoLaboral(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoPorConceptosPorPuestoLaboral" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:971
def listadoSeguroSepelio(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoSeguroSepelio" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:969
def comparativoCertificacion(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/comparativoCertificacion" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:998
def exportDatosPorConcepto(liquidacionId:Long, conceptoId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionAcciones/exportDatosPorConcepto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("liquidacionId", liquidacionId)), Some(implicitly[QueryStringBindable[Long]].unbind("conceptoId", conceptoId)))))
}
                                                

// @LINE:982
def modalDatosAfip(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/modalDatosAfip")
}
                                                

// @LINE:983
def reportesDatosAfip(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/reportesDatosAfip")
}
                                                

// @LINE:986
def reportesDatosAfipGanancias(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/reportesDatosAfipGanancias")
}
                                                

// @LINE:979
def listadoGeneral(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoGeneral" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:981
def listadoPorEscalaPorPuestoLaboral(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoPorEscalaPorPuestoLaboral" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:985
def modalDatosAfipGanancias(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/modalDatosAfipGanancias")
}
                                                

// @LINE:976
def controlDescuentosBasicos(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/controlDescuentosBasicos" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:970
def listadoSeguroVida(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacionMes/reportes/listadoSeguroVida" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:893
// @LINE:892
// @LINE:891
// @LINE:890
// @LINE:889
// @LINE:888
class ReverseLiquidacionDetallesController {
    

// @LINE:888
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacion-detalle/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:893
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacion-detalle/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:891
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacion-detalle/guardar")
}
                                                

// @LINE:892
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "haberes/liquidacion-detalle/actualizar")
}
                                                

// @LINE:890
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacion-d20301766700etalle/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:889
def crear(liquidacionPuestoId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "haberes/liquidacion-detalle/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("liquidacionPuestoId", liquidacionPuestoId)))))
}
                                                
    
}
                          
}
                  

// @LINE:734
// @LINE:733
package controllers.rendiciones {

// @LINE:733
class ReverseIndexController {
    

// @LINE:733
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rendiciones")
}
                                                
    
}
                          

// @LINE:734
class ReverseRendicionesController {
    

// @LINE:734
def indexPagosRealizados(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rendiciones/pagos-realizados")
}
                                                
    
}
                          
}
                  

// @LINE:1051
// @LINE:1044
// @LINE:1041
// @LINE:1040
// @LINE:1039
// @LINE:1037
// @LINE:1035
// @LINE:1034
// @LINE:1023
// @LINE:1021
// @LINE:1020
// @LINE:1019
// @LINE:425
// @LINE:424
// @LINE:423
// @LINE:421
// @LINE:420
// @LINE:419
// @LINE:418
// @LINE:417
// @LINE:416
// @LINE:414
// @LINE:413
// @LINE:412
// @LINE:411
// @LINE:410
// @LINE:409
// @LINE:407
// @LINE:406
// @LINE:405
// @LINE:404
// @LINE:403
// @LINE:402
// @LINE:401
// @LINE:400
// @LINE:388
// @LINE:387
// @LINE:386
// @LINE:385
// @LINE:384
// @LINE:383
// @LINE:382
// @LINE:381
// @LINE:380
// @LINE:379
// @LINE:378
// @LINE:376
// @LINE:374
// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
// @LINE:367
// @LINE:366
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:362
// @LINE:361
// @LINE:360
// @LINE:359
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:354
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:349
// @LINE:348
// @LINE:347
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:337
// @LINE:336
// @LINE:334
// @LINE:333
// @LINE:332
// @LINE:331
// @LINE:330
// @LINE:329
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:315
// @LINE:314
// @LINE:313
// @LINE:312
// @LINE:311
// @LINE:309
// @LINE:308
// @LINE:307
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:296
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:287
// @LINE:286
// @LINE:285
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:278
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
// @LINE:268
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:260
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:253
// @LINE:252
// @LINE:250
// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:245
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:240
// @LINE:239
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
// @LINE:231
// @LINE:228
// @LINE:227
// @LINE:226
// @LINE:225
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:216
// @LINE:215
// @LINE:213
// @LINE:211
// @LINE:210
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:203
// @LINE:202
// @LINE:201
// @LINE:200
// @LINE:199
// @LINE:198
// @LINE:196
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
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
// @LINE:162
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
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:104
// @LINE:103
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:92
// @LINE:91
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
package controllers.compras {

// @LINE:374
// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
class ReverseCertificacionesComprasLineasController {
    

// @LINE:369
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:374
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:372
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra-linea/guardar")
}
                                                

// @LINE:373
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra-linea/actualizar")
}
                                                

// @LINE:371
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:370
def crear(certificacionId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("certificacionId", certificacionId)))))
}
                                                
    
}
                          

// @LINE:223
// @LINE:222
// @LINE:219
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
class ReverseOrdenesReportesController {
    

// @LINE:108
def exportacionDatosConLineas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenCompra/reporte/exportacionDatosConLineas")
}
                                                

// @LINE:107
def exportacionDatos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenCompra/reporte/exportacionDatos")
}
                                                

// @LINE:106
def cuadroComparativoPrecios(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenCompra/reporte/cuadroComparativoPrecios")
}
                                                

// @LINE:222
def listadoLineas(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "orden/reporte/listadoLineas" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:111
def reporteCertificacionPaciente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "ordenCompra/reporte/reporteCertificacionPaciente" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:109
def cuadroSugerenciaAdjudicación(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenCompra/reporte/cuadroSugerenciaAdjudicacion")
}
                                                

// @LINE:110
def controlDolar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenCompra/reporte/controlDolar")
}
                                                

// @LINE:223
def reporteImputacionDefinitiva(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/reporte/imputacionDefinitiva" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:219
def reporteImputacionDefinitivaGlobal(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/reporte/imputacionDefinitiva")
}
                                                

// @LINE:112
def controlProfe(id:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "ordenCompra/reporte/controlProfe" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:250
// @LINE:249
// @LINE:231
// @LINE:228
// @LINE:227
// @LINE:226
// @LINE:225
// @LINE:221
// @LINE:220
// @LINE:218
class ReverseSolicitudesReportesController {
    

// @LINE:218
def reporteImputacionPreventivaLista(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/imputacionPreventiva")
}
                                                

// @LINE:249
def reportePedidoAbastecimiento(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/reporte/reportePedidoAbastecimiento" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:228
def informeFarmaciaPorUsuario(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/informeFarmaciaPorUsuario")
}
                                                

// @LINE:221
def reporteLineasCotizacion(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/lineasCotizacion" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:231
def informeFarmaciaPaciente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/informeFarmaciaPaciente")
}
                                                

// @LINE:220
def reporteCuadroSolicitud(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/cuadroSolicitud")
}
                                                

// @LINE:226
def informeFarmacia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/informeFarmacia")
}
                                                

// @LINE:250
def reporteImputacionPreventiva(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/reporte/imputacionPreventiva" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:227
def modalInformeFarmaciaPorUsuario(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/modalInformeFarmaciaPorUsuario")
}
                                                

// @LINE:225
def modalInformeFarmacia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/reporte/modalInformeFarmacia")
}
                                                
    
}
                          

// @LINE:216
// @LINE:215
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
class ReverseCertificacionesController {
    

// @LINE:172
def cambiarEstado(idCertificacion:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idCertificacion", idCertificacion)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:165
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/crear")
}
                                                

// @LINE:171
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:216
def procesarMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificaciones/acciones/procesar-masivo")
}
                                                

// @LINE:169
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:168
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:166
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/guardar")
}
                                                

// @LINE:173
def modalEditarCuentaAnalica(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalEditarCuentaAnalitica")
}
                                                

// @LINE:174
def editarCuentaAnalitica(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/editarCuentaAnalitica")
}
                                                

// @LINE:215
def crearMasivo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificaciones/acciones/crear-masivo")
}
                                                

// @LINE:167
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:164
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion")
}
                                                

// @LINE:170
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
class ReverseOrdenesLineasAjustesController {
    

// @LINE:114
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/linea-orden-ajuste/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:116
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/linea-orden-ajuste/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:117
def crear(ordenId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/linea-orden-ajuste/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("ordenId", ordenId)))))
}
                                                

// @LINE:115
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/linea-orden-ajuste/guardar")
}
                                                
    
}
                          

// @LINE:1037
// @LINE:266
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:260
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:253
// @LINE:252
class ReverseProveedoresController {
    

// @LINE:261
def guardarContacto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/proveedores/guardarContacto")
}
                                                

// @LINE:253
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/crear")
}
                                                

// @LINE:264
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:257
def eliminarContacto(sid:Long, cId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/eliminarContacto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("sid", sid)), Some(implicitly[QueryStringBindable[Long]].unbind("cId", cId)))))
}
                                                

// @LINE:266
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:256
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:255
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/proveedores/guardar")
}
                                                

// @LINE:1037
def suggestProveedor(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestProveedor/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:262
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/proveedores/actualizar")
}
                                                

// @LINE:260
def actualizarContacto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/proveedores/actualizarContacto")
}
                                                

// @LINE:263
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/modalBuscar")
}
                                                

// @LINE:259
def formularioContacto(proveedorId:Long, id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/editarContacto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("proveedorId", proveedorId)), if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:258
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:252
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores")
}
                                                
    
}
                          

// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:354
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:349
// @LINE:348
// @LINE:347
class ReverseCertificacionesComprasController {
    

// @LINE:355
def cambiarEstado(idCertificacion:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idCertificacion", idCertificacion)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:348
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/crear")
}
                                                

// @LINE:354
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:352
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:351
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:349
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/guardar")
}
                                                

// @LINE:356
def modalEditarCuentaAnalica(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/modalEditarCuentaAnalitica")
}
                                                

// @LINE:357
def editarCuentaAnalitica(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/editarCuentaAnalitica")
}
                                                

// @LINE:350
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:347
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra")
}
                                                

// @LINE:353
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
class ReverseLineasSolicitudesController {
    

// @LINE:121
def editar(id:Long, idDeposito:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-solicitud/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(idDeposito == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idDeposito", idDeposito)))))
}
                                                

// @LINE:120
def crear(solicitudId:String, idDeposito:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-solicitud/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("solicitudId", solicitudId)), Some(implicitly[QueryStringBindable[Long]].unbind("idDeposito", idDeposito)))))
}
                                                

// @LINE:119
def index(id:Long = 0, editable:Boolean = false, btnEliminar:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-solicitud/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)), if(btnEliminar == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("btnEliminar", btnEliminar)))))
}
                                                

// @LINE:124
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-solicitud/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:122
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-solicitud/guardar")
}
                                                

// @LINE:123
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-solicitud/actualizar")
}
                                                

// @LINE:125
def eliminarMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-solicitud/eliminarMasivo")
}
                                                
    
}
                          

// @LINE:1021
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:315
// @LINE:314
// @LINE:313
// @LINE:312
// @LINE:311
class ReverseTipoProductosController {
    

// @LINE:315
def eliminarTipoProducto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/tipo-producto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:316
def actualizarTipoProducto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/tipo-producto/actualizar")
}
                                                

// @LINE:314
def editarTipoProducto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/tipo-producto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:313
def guardarTipoProducto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/tipo-producto/guardar")
}
                                                

// @LINE:318
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/tipo-producto/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:312
def crearTipoProducto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/tipo-producto/crear")
}
                                                

// @LINE:317
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/tipo-producto/modalBuscar")
}
                                                

// @LINE:311
def indexTipoProducto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/tipo-producto")
}
                                                

// @LINE:1021
def suggestTipoProducto(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestTipoProducto/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                
    
}
                          

// @LINE:248
// @LINE:247
// @LINE:162
// @LINE:161
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
// @LINE:141
// @LINE:140
class ReverseOrdenesAccionesController {
    

// @LINE:156
def modalEditarRubro(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalEditarRubro" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:151
def editarMontoAdelanto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/editarMontoAdelanto")
}
                                                

// @LINE:248
def generarOrdenSegunCuadroSugerenia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/acciones/generarOrdenSegunCuadroSugerenia")
}
                                                

// @LINE:141
def importarListaProductos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/importarListaProductos")
}
                                                

// @LINE:155
def editarFechaProvision(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/editarFechaProvision")
}
                                                

// @LINE:158
def modalOrdenMail(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalOrdenMail" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:247
def combinar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/acciones/combinar")
}
                                                

// @LINE:150
def modalEditarMontoAdelanto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalEditarMontoAdelanto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:157
def editarRubro(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/editarRubro")
}
                                                

// @LINE:161
def modalCrearDispo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalCrearDispo" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:140
def modalImportarListaProductos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/modalImportarListaProductos")
}
                                                

// @LINE:162
def crearDispo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/crearDispo")
}
                                                

// @LINE:152
def modalEditarCotDolar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalEditarCotDolar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:154
def modalEditarFechaProvision(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalEditarFechaProvision" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:159
def enviarOrdenMail(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/enviarOrdenMail")
}
                                                

// @LINE:153
def editarCotDolar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/editarCotDolar")
}
                                                
    
}
                          

// @LINE:1019
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
class ReverseArticulosController {
    

// @LINE:1019
def suggestArticulo(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestArticulo/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:323
def editarArticulo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/articulo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:320
def indexArticulo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/articulo")
}
                                                

// @LINE:327
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/articulo/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:324
def eliminarArticulo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/articulo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:322
def guardarArticulo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/articulo/guardar")
}
                                                

// @LINE:326
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/articulo/modalBuscar")
}
                                                

// @LINE:325
def actualizarArticulo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/articulo/actualizar")
}
                                                

// @LINE:321
def crearArticulo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/articulo/crear")
}
                                                
    
}
                          

// @LINE:211
// @LINE:210
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:205
class ReverseCertificacionesComprasLineaAjustesController {
    

// @LINE:205
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea-ajuste/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:211
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea-ajuste/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:208
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-linea-ajuste/guardar")
}
                                                

// @LINE:210
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-linea-ajuste/actualizar")
}
                                                

// @LINE:207
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea-ajuste/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:206
def crear(certificacionId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea-ajuste/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("certificacionId", certificacionId)))))
}
                                                
    
}
                          

// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
class ReverseAjustesSolicitudesController {
    

// @LINE:128
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/ajuste-solicitud/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:131
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/ajuste-solicitud/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:129
def crear(solicitudId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/ajuste-solicitud/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("solicitudId", solicitudId)))))
}
                                                

// @LINE:130
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/ajuste-solicitud/guardar")
}
                                                
    
}
                          

// @LINE:334
// @LINE:333
// @LINE:332
// @LINE:331
// @LINE:330
// @LINE:329
class ReverseProveedorAtributosController {
    

// @LINE:329
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-atributo/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:334
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-atributo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:332
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-proveedor-atributo/guardar")
}
                                                

// @LINE:333
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-proveedor-atributo/actualizar")
}
                                                

// @LINE:331
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-atributo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:330
def crear(proveedorId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-atributo/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("proveedorId", proveedorId)))))
}
                                                
    
}
                          

// @LINE:203
// @LINE:202
// @LINE:201
// @LINE:200
// @LINE:199
// @LINE:198
class ReverseLineasCertificacionesController {
    

// @LINE:198
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:203
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:201
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-linea/guardar")
}
                                                

// @LINE:202
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-linea/actualizar")
}
                                                

// @LINE:200
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:199
def crear(certificacionId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("certificacionId", certificacionId)))))
}
                                                
    
}
                          

// @LINE:160
class ReverseOrdenSubrubroController {
    

// @LINE:160
def listOptions(rubroId:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/ordenSubrubro/listOptions" + queryString(List(if(rubroId == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("rubroId", rubroId)))))
}
                                                
    
}
                          

// @LINE:414
// @LINE:413
// @LINE:412
// @LINE:411
// @LINE:410
// @LINE:409
// @LINE:407
// @LINE:406
// @LINE:405
// @LINE:404
// @LINE:403
// @LINE:402
// @LINE:401
// @LINE:400
class ReverseCajaChicaController {
    

// @LINE:407
def cambiarEstado(id:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:410
def reporteImputacionPreventivaLista(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/reporteImputacionPreventivaLista" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:402
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/crear")
}
                                                

// @LINE:405
def actualizar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:409
def resumenPresupuesto(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/resumenPresupuesto" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:401
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:411
def reporteImputacionPreventivaAjustesLista(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/reporteImputacionPreventivaListaAjuste" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:406
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:403
def guardar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/guardar")
}
                                                

// @LINE:413
def reporteCajaChica(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/reporteCajaChica" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:404
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:400
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica")
}
                                                

// @LINE:412
def reporteImputacionDefinitiva(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/reporteImputacionDefinitiva" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:414
def reporteCajaChicaOrdenCargo(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica/reporteCajaChicaOrdenCargo" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:1039
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:278
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
class ReverseClientesController {
    

// @LINE:271
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/crear")
}
                                                

// @LINE:281
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:278
def eliminarContacto(sid:Long, cId:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/eliminarContacto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("sid", sid)), Some(implicitly[QueryStringBindable[Long]].unbind("cId", cId)))))
}
                                                

// @LINE:276
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:275
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:272
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/clientes/guardar")
}
                                                

// @LINE:274
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/clientes/actualizar")
}
                                                

// @LINE:280
def actualizarContacto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/clientes/actualizarContacto")
}
                                                

// @LINE:279
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/modalBuscar")
}
                                                

// @LINE:282
def modalCarga(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/modalCargar")
}
                                                

// @LINE:277
def formularioContacto(clienteId:Long, id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/editarContacto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("clienteId", clienteId)), if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1039
def suggestCliente(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestCliente/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:283
def guardarDesdeModal(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/guardarDesdeModal")
}
                                                

// @LINE:273
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:270
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/clientes")
}
                                                
    
}
                          

// @LINE:239
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
class ReversePedidosFondosController {
    

// @LINE:234
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedidoFondo/crear")
}
                                                

// @LINE:239
def actualizar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedidoFondo/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:238
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedidoFondo/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:237
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedidoFondo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:235
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/pedidoFondo/guardar")
}
                                                

// @LINE:236
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedidoFondo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:233
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedidoFondo")
}
                                                
    
}
                          

// @LINE:196
// @LINE:195
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
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
class ReverseCertificacionesAccionesController {
    

// @LINE:178
def pasarCertificadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/pasarCertificadoMasivo")
}
                                                

// @LINE:190
def modalDuplicarMasivo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalDuplicarMasivo")
}
                                                

// @LINE:195
def modalDetalleCertificacion(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalDetalleCertificacion" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:181
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalPasarBorrador")
}
                                                

// @LINE:193
def crearAguinaldo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/CrearAguinaldo")
}
                                                

// @LINE:191
def duplicarMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/duplicarMasivo")
}
                                                

// @LINE:179
def modalPasarAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalPasarAprobado")
}
                                                

// @LINE:192
def modalCrearAguinaldo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalCrearAguinaldo")
}
                                                

// @LINE:184
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/pasarCanceladoMasivo")
}
                                                

// @LINE:182
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/pasarBorradorMasivo")
}
                                                

// @LINE:185
def modalEditarFechaCertificacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalEditarFechaCertificacion")
}
                                                

// @LINE:183
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalPasarCancelado")
}
                                                

// @LINE:180
def pasarAprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/pasarAprobadoMasivo")
}
                                                

// @LINE:186
def editarFechaCertificacionMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/editarFechaCertificacionMasivo")
}
                                                

// @LINE:196
def modalDetalleCertificacionesPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("nombrePeriodo", nombrePeriodo)), Some(implicitly[QueryStringBindable[Integer]].unbind("estado", estado)), Some(implicitly[QueryStringBindable[Integer]].unbind("proveedorId", proveedorId)))))
}
                                                

// @LINE:175
def modalPasarEnCurso(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalPasarEnCurso")
}
                                                

// @LINE:177
def modalPasarCertificado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion/modalPasarCertificado")
}
                                                

// @LINE:176
def pasarEnCursoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/pasarEnCursoMasivo")
}
                                                
    
}
                          

// @LINE:104
// @LINE:103
class ReverseOrdenesLineasClientesController {
    

// @LINE:103
def guardarAjax(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-orden-cliente/guardarAjax")
}
                                                

// @LINE:104
def eliminarAjax(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-orden-cliente/eliminarAjax" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:1051
// @LINE:344
// @LINE:343
class ReverseObrasSocialesController {
    

// @LINE:343
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/ob/modalBuscar")
}
                                                

// @LINE:1051
def suggestObrasocial(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestOb/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:344
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/ob/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:425
// @LINE:424
// @LINE:423
class ReverseCajaChicaPresupuestoLineasController {
    

// @LINE:424
def crear(cajaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica-presupuesto/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("cajaId", cajaId)))))
}
                                                

// @LINE:423
def lista(cajaId:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica-presupuesto" + queryString(List(if(cajaId == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("cajaId", cajaId)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:425
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/caja-chica-presupuesto/guardar")
}
                                                
    
}
                          

// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:337
// @LINE:336
class ReverseProveedorDatosDgrController {
    

// @LINE:337
def crear(cuit:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-datodgr/crear" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("cuit", cuit)))))
}
                                                

// @LINE:336
def index(cuit:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-datodgr/index" + queryString(List(if(cuit == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("cuit", cuit)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:341
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-datodgr/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:339
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-proveedor-datodgr/guardar")
}
                                                

// @LINE:340
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-proveedor-datodgr/actualizar")
}
                                                

// @LINE:338
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-proveedor-datodgr/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
class ReverseLineasOrdenesController {
    

// @LINE:94
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-orden/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:99
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-orden/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:97
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-orden/guardar")
}
                                                

// @LINE:98
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-orden/actualizar")
}
                                                

// @LINE:101
def eliminarMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/linea-orden/eliminar-masivo")
}
                                                

// @LINE:96
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-orden/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:95
def crear(ordenId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-orden/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("ordenId", ordenId)))))
}
                                                

// @LINE:100
def modalAddClientes(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/linea-orden/modalAddClientes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:421
// @LINE:420
// @LINE:419
// @LINE:418
// @LINE:417
// @LINE:416
class ReverseCajaChicaMovimientosController {
    

// @LINE:421
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica-movimientos/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:419
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/caja-chica-movimientos/guardar")
}
                                                

// @LINE:420
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/caja-chica-movimientos/actualizar")
}
                                                

// @LINE:416
def lista(cajaId:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica-movimientos" + queryString(List(if(cajaId == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("cajaId", cajaId)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:418
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica-movimientos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:417
def crear(cajaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/caja-chica-movimientos/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("cajaId", cajaId)))))
}
                                                
    
}
                          

// @LINE:388
// @LINE:387
// @LINE:386
// @LINE:385
// @LINE:384
// @LINE:383
// @LINE:382
// @LINE:381
// @LINE:380
// @LINE:379
// @LINE:378
class ReverseCertificacionesObrasController {
    

// @LINE:386
def cambiarEstado(idCertificacion:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idCertificacion", idCertificacion)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:379
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/crear")
}
                                                

// @LINE:385
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-obra/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:383
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:382
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:380
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-obra/guardar")
}
                                                

// @LINE:387
def modalEditarCuentaAnalica(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/modalEditarCuentaAnalitica")
}
                                                

// @LINE:388
def editarCuentaAnalitica(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-obra/editarCuentaAnalitica")
}
                                                

// @LINE:381
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:378
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra")
}
                                                

// @LINE:384
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-obra/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:1020
// @LINE:309
// @LINE:308
// @LINE:307
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
class ReverseCategoriasController {
    

// @LINE:307
def actualizarCategoria(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/categorias/actualizar")
}
                                                

// @LINE:306
def eliminarCategoria(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/categorias/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:305
def editarCategoria(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/categorias/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1020
def suggestCategoria(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestCategoria/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:309
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/categorias/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:308
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/categorias/modalBuscar")
}
                                                

// @LINE:302
def indexCategoria(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/categorias")
}
                                                

// @LINE:304
def guardarCategoria(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/categorias/guardar")
}
                                                

// @LINE:303
def crearCategoria(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/categorias/crear")
}
                                                
    
}
                          

// @LINE:245
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:240
class ReverseLineasPedidosFondosController {
    

// @LINE:240
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedido-fondo-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:245
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedido-fondo-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:243
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/pedido-fondo-linea/guardar")
}
                                                

// @LINE:244
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/pedido-fondo-linea/actualizar")
}
                                                

// @LINE:242
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedido-fondo-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:241
def crear(pedidoFondoId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/pedido-fondo-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("pedidoFondoId", pedidoFondoId)))))
}
                                                
    
}
                          

// @LINE:65
class ReverseIndexController {
    

// @LINE:65
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras")
}
                                                
    
}
                          

// @LINE:1035
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseOrdenesController {
    

// @LINE:146
def cambiarEstado(idOrden:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idOrden", idOrden)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:134
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/crear")
}
                                                

// @LINE:139
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1035
def suggestOrden(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestOrden/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:143
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:137
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:135
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/guardar")
}
                                                

// @LINE:148
def get(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:147
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalBuscar")
}
                                                

// @LINE:144
def modalEditarCuentaAnalica(tipo:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/modalEditarCuentaAnalitica" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("tipo", tipo)))))
}
                                                

// @LINE:145
def editarCuentaAnalitica(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/orden/editarCuentaAnalitica")
}
                                                

// @LINE:136
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:133
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden")
}
                                                

// @LINE:138
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/orden/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:92
// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
class ReverseSolicitudAccionesController {
    

// @LINE:86
def modalPasarAprobadoPorPresupuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modalPasarAprobadoPorPresupuesto")
}
                                                

// @LINE:92
def asignarUsuario(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/asignarUsuario")
}
                                                

// @LINE:87
def pasarAprobadoPorPresupuesto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/pasarAprobadoPorPresupuesto")
}
                                                

// @LINE:83
def importarListaProductos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/importarListaProductos")
}
                                                

// @LINE:85
def modificarPaciente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/modificarPaciente")
}
                                                

// @LINE:89
def pasarAutorizado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/pasarAutorizado")
}
                                                

// @LINE:84
def modalModificarPaciente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modalModificarPacientes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:91
def modalAsignarUsuario(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modalAsignarUsuario" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:82
def modalImportarListaProductos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/modalImportarListaProductos")
}
                                                

// @LINE:88
def modalPasarAutorizado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modalPasarAutorizado")
}
                                                
    
}
                          

// @LINE:268
// @LINE:265
class ReverseProveedoresAccionesController {
    

// @LINE:268
def actualizarMail(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/proveedores/actualizarMail")
}
                                                

// @LINE:265
def modalInformacionProveedor(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/proveedores/modalInformacionProveedor" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:376
class ReverseCertificacionesComprasReportesController {
    

// @LINE:376
def reporteCertificacion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificaciones-compra/reporteCertificacion")
}
                                                
    
}
                          

// @LINE:1034
// @LINE:81
// @LINE:80
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
class ReverseSolicitudesController {
    

// @LINE:75
def cambiarEstado(idSolicitud:Long, idEstado:Long, searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idSolicitud", idSolicitud)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)), Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:68
def guardarSolicitud(searchIndex:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/guardar" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:70
def editar(id:Long, searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:67
def crearSolicitud(searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:76
def redirectSearchIndex(searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/redirectIndex" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:1034
def suggestSolicitud(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestSolicitud/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:81
def get(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:72
def eliminar(id:Long, searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:78
def modalEditarCuentaAnalica(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modalEditarCuentaAnalitica")
}
                                                

// @LINE:80
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modalBuscar")
}
                                                

// @LINE:79
def editarCuentaAnalitica(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/editarCuentaAnalitica")
}
                                                

// @LINE:69
def ver(id:Long, searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:71
def duplicar(id:Long, searchIndex:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                

// @LINE:74
def modificarEntregado(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud/modificarEntregado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:66
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/solicitud")
}
                                                

// @LINE:73
def actualizar(id:Long, searchIndex:String): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/solicitud/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[String]].unbind("searchIndex", searchIndex)))))
}
                                                
    
}
                          

// @LINE:213
// @LINE:194
// @LINE:189
// @LINE:188
// @LINE:187
class ReverseCertificacionesReportesController {
    

// @LINE:189
def bajas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion/reportes/bajas")
}
                                                

// @LINE:188
def reporteElevaciones(desc:Boolean): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/reporteElevaciones" + queryString(List(Some(implicitly[QueryStringBindable[Boolean]].unbind("desc", desc)))))
}
                                                

// @LINE:187
def reporteTasas(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/reporteTasa")
}
                                                

// @LINE:194
def reportePlanillaSueldos(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/reportePlanilla")
}
                                                

// @LINE:213
def reporteCertificacion(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificaciones/reporteCertificacion")
}
                                                
    
}
                          

// @LINE:1044
// @LINE:1041
// @LINE:1040
// @LINE:1023
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:296
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:287
// @LINE:286
// @LINE:285
class ReverseProductosController {
    

// @LINE:289
def editarProducto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/productos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:294
def modalBuscarSolicitudes(idSolicitud:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/modalBuscarSolicitudes" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idSolicitud", idSolicitud)))))
}
                                                

// @LINE:1023
def suggestUdm(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestUdm/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:295
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:298
def cargaProductoRismi(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/cargaProductoRismi")
}
                                                

// @LINE:291
def actualizarProducto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/producto/actualizar")
}
                                                

// @LINE:286
def listarProducto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/productos/")
}
                                                

// @LINE:1040
def suggestProducto(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestProducto/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:296
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:290
def eliminarProducto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/productos/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:285
def indexProducto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/productos")
}
                                                

// @LINE:292
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/modalBuscar")
}
                                                

// @LINE:299
def modalCarga(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/modalCargar")
}
                                                

// @LINE:288
def guardarProducto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/productos/guardar")
}
                                                

// @LINE:293
def modalBuscarIps(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/modalBuscarIps")
}
                                                

// @LINE:300
def guardarProductoDesdeModal(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/producto/guardarProductoDesdeModal")
}
                                                

// @LINE:1044
def getDataSuggestSolicitud(input:String, idDeposito:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestProductoSolicitud/" + implicitly[PathBindable[Long]].unbind("idDeposito", idDeposito) + "/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:297
def getPrecioProducto(producto_id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/producto/getPrecio" + queryString(List(if(producto_id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("producto_id", producto_id)))))
}
                                                

// @LINE:287
def crearProducto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/productos/crear")
}
                                                

// @LINE:1041
def suggestProductoPresupuesto(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestProductoPresupuesto/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                
    
}
                          

// @LINE:367
// @LINE:366
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:362
// @LINE:361
// @LINE:360
// @LINE:359
// @LINE:358
class ReverseCertificacionesComprasAccionesController {
    

// @LINE:361
def pasarCertificadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/pasarCertificadoMasivo")
}
                                                

// @LINE:362
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/modalPasarBorrador")
}
                                                

// @LINE:365
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/pasarCanceladoMasivo")
}
                                                

// @LINE:363
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/pasarBorradorMasivo")
}
                                                

// @LINE:366
def modalEditarFechaCertificacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/modalEditarFechaCertificacion")
}
                                                

// @LINE:364
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/modalPasarCancelado")
}
                                                

// @LINE:367
def editarFechaCertificacionMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/editarFechaCertificacionMasivo")
}
                                                

// @LINE:358
def modalPasarEnCurso(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/modalPasarEnCurso")
}
                                                

// @LINE:360
def modalPasarCertificado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "compras/certificacion-compra/modalPasarCertificado")
}
                                                

// @LINE:359
def pasarEnCursoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "compras/certificacion-compra/pasarEnCursoMasivo")
}
                                                
    
}
                          
}
                  

// @LINE:1053
// @LINE:1033
// @LINE:1030
// @LINE:1029
// @LINE:1028
// @LINE:1027
// @LINE:1026
// @LINE:663
// @LINE:662
// @LINE:661
// @LINE:660
// @LINE:659
// @LINE:658
// @LINE:656
// @LINE:655
// @LINE:654
// @LINE:653
// @LINE:652
// @LINE:651
// @LINE:649
// @LINE:648
// @LINE:646
// @LINE:645
// @LINE:643
// @LINE:642
// @LINE:640
// @LINE:638
// @LINE:637
// @LINE:636
// @LINE:635
// @LINE:634
// @LINE:633
// @LINE:632
// @LINE:631
// @LINE:629
// @LINE:628
// @LINE:627
// @LINE:626
// @LINE:625
// @LINE:624
// @LINE:622
// @LINE:621
// @LINE:620
// @LINE:618
// @LINE:617
// @LINE:616
// @LINE:615
// @LINE:613
// @LINE:612
// @LINE:611
// @LINE:610
// @LINE:609
// @LINE:608
// @LINE:607
// @LINE:606
// @LINE:605
// @LINE:602
// @LINE:600
// @LINE:599
// @LINE:598
// @LINE:597
// @LINE:596
// @LINE:595
// @LINE:594
// @LINE:593
// @LINE:592
// @LINE:591
// @LINE:589
// @LINE:588
// @LINE:587
// @LINE:586
// @LINE:585
// @LINE:584
// @LINE:583
// @LINE:582
// @LINE:581
// @LINE:580
// @LINE:579
// @LINE:578
// @LINE:576
// @LINE:575
// @LINE:574
// @LINE:573
// @LINE:572
// @LINE:571
// @LINE:570
// @LINE:569
// @LINE:567
// @LINE:566
// @LINE:565
// @LINE:564
// @LINE:563
// @LINE:562
// @LINE:561
// @LINE:560
// @LINE:559
// @LINE:557
// @LINE:556
// @LINE:554
// @LINE:553
// @LINE:551
// @LINE:550
// @LINE:549
// @LINE:548
// @LINE:547
// @LINE:546
// @LINE:545
// @LINE:544
// @LINE:542
// @LINE:541
// @LINE:540
// @LINE:539
// @LINE:538
// @LINE:537
// @LINE:535
// @LINE:534
// @LINE:533
// @LINE:532
// @LINE:531
// @LINE:530
// @LINE:528
// @LINE:527
// @LINE:526
// @LINE:525
// @LINE:524
// @LINE:523
// @LINE:521
// @LINE:520
// @LINE:519
// @LINE:518
// @LINE:517
// @LINE:516
// @LINE:514
// @LINE:513
// @LINE:512
// @LINE:511
// @LINE:510
// @LINE:509
// @LINE:507
// @LINE:506
// @LINE:505
// @LINE:504
// @LINE:503
// @LINE:502
// @LINE:501
// @LINE:500
// @LINE:499
// @LINE:498
package controllers.rrhh {

// @LINE:663
// @LINE:662
// @LINE:661
// @LINE:660
// @LINE:659
// @LINE:658
class ReverseAgentesSeguimientoLineasController {
    

// @LINE:658
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/seguimiento-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:663
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/seguimiento-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:661
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/seguimiento-linea/guardar")
}
                                                

// @LINE:662
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/seguimiento-linea/actualizar")
}
                                                

// @LINE:660
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/seguimiento-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:659
def crear(seguimientoId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/seguimiento-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("seguimientoId", seguimientoId)))))
}
                                                
    
}
                          

// @LINE:507
// @LINE:506
// @LINE:505
// @LINE:504
// @LINE:503
// @LINE:502
// @LINE:501
class ReverseAgentesEstudiosController {
    

// @LINE:507
def listOptionsEstudioSubareas(estudioAreaId:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/listOptionsSubarea" + queryString(List(if(estudioAreaId == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("estudioAreaId", estudioAreaId)))))
}
                                                

// @LINE:501
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:506
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:504
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/guardar")
}
                                                

// @LINE:505
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/actualizar")
}
                                                

// @LINE:503
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:502
def crear(agenteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-estudio/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("agenteId", agenteId)))))
}
                                                
    
}
                          

// @LINE:528
// @LINE:527
// @LINE:526
// @LINE:525
// @LINE:524
// @LINE:523
class ReverseAgentesHijosController {
    

// @LINE:523
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-hijo/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:528
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-hijo/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:526
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-hijo/guardar")
}
                                                

// @LINE:527
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-hijo/actualizar")
}
                                                

// @LINE:525
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-hijo/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:524
def crear(agenteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-hijo/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("agenteId", agenteId)))))
}
                                                
    
}
                          

// @LINE:646
// @LINE:645
class ReverseAgentesAsistenciasReportesController {
    

// @LINE:645
def reporteLicencia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agenteAsistencia/reporteLicencia")
}
                                                

// @LINE:646
def reporteLicenciaMedicinaLaboral(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agenteAsistencia/reporteLicenciaMedicinaLaboral")
}
                                                
    
}
                          

// @LINE:514
// @LINE:513
// @LINE:512
// @LINE:511
// @LINE:510
// @LINE:509
class ReverseAgentesRulController {
    

// @LINE:509
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-rul/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:514
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-rul/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:512
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-rul/guardar")
}
                                                

// @LINE:513
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-rul/actualizar")
}
                                                

// @LINE:511
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-rul/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:510
def crear(agenteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-rul/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("agenteId", agenteId)))))
}
                                                
    
}
                          

// @LINE:618
// @LINE:617
// @LINE:616
// @LINE:615
class ReverseAgentesReportesController {
    

// @LINE:617
def reportesDatosAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/reportes/reportesDatosAgente")
}
                                                

// @LINE:615
def ficha(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/reportes/ficha" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:616
def fichaAptitud(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/reportes/fichaAptitud" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:618
def reportesCertificacionesAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/reportes/reportesCertificacionesAgente")
}
                                                
    
}
                          

// @LINE:1029
// @LINE:567
// @LINE:566
// @LINE:565
// @LINE:564
// @LINE:563
// @LINE:562
// @LINE:561
// @LINE:560
// @LINE:559
class ReverseTipoResidenciasController {
    

// @LINE:561
def indexTipoResidencia(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia")
}
                                                

// @LINE:563
def guardarTipoResidencia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/guardar")
}
                                                

// @LINE:560
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:566
def actualizarTipoResidencia(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/actualizar")
}
                                                

// @LINE:562
def crearTipoResidencia(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/crear")
}
                                                

// @LINE:567
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1029
def suggestTipoResidencia(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestTipoResidencia/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:565
def eliminarTipoResidencia(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:559
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/modalBuscar")
}
                                                

// @LINE:564
def editarTipoResidencia(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/tipoResidencia/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:613
// @LINE:612
// @LINE:611
// @LINE:610
// @LINE:609
// @LINE:608
// @LINE:607
// @LINE:606
// @LINE:605
class ReverseNovedadesController {
    

// @LINE:608
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades/crear")
}
                                                

// @LINE:606
def ver(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades/ver" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:607
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:609
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/novedades/guardar")
}
                                                

// @LINE:611
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/novedades/actualizar")
}
                                                

// @LINE:612
def lista(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades/lista")
}
                                                

// @LINE:613
def getFeriados(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades/feriados")
}
                                                

// @LINE:610
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:605
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/novedades")
}
                                                
    
}
                          

// @LINE:1027
// @LINE:551
// @LINE:550
// @LINE:549
// @LINE:548
// @LINE:547
// @LINE:546
// @LINE:545
// @LINE:544
class ReverseEspecialidadesController {
    

// @LINE:1027
def suggestEspecialidad(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestEspecialidad/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:548
def eliminarEspecialidad(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/especialidad/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:549
def actualizarEspecialidad(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/especialidad/actualizar")
}
                                                

// @LINE:551
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/especialidad/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:547
def editarEspecialidad(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/especialidad/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:550
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/especialidad/modalBuscar")
}
                                                

// @LINE:546
def guardarEspecialidad(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/especialidad/guardar")
}
                                                

// @LINE:545
def crearEspecialidad(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/especialidad/crear")
}
                                                

// @LINE:544
def indexEspecialidad(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/especialidad")
}
                                                
    
}
                          

// @LINE:643
// @LINE:642
// @LINE:640
// @LINE:638
// @LINE:637
// @LINE:636
// @LINE:635
// @LINE:634
// @LINE:633
// @LINE:632
// @LINE:631
// @LINE:629
// @LINE:628
// @LINE:627
// @LINE:626
// @LINE:625
// @LINE:624
class ReverseAgentesAsistenciasLicenciasController {
    

// @LINE:631
def modalPasarBorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/modalPasarBorrador")
}
                                                

// @LINE:640
def resumen(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/resumen" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:624
def index(id:Long = 0, editable:Boolean = false, tipoLicencia:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)), if(tipoLicencia == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("tipoLicencia", tipoLicencia)))))
}
                                                

// @LINE:636
def pasarPreAprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/pasarPreAprobadoMasivo")
}
                                                

// @LINE:643
def getListaLicenciasEnFecha(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/getListaLicenciasEnFecha")
}
                                                

// @LINE:629
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:637
def modalPasarAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/modalPasarAprobado")
}
                                                

// @LINE:627
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencian/guardar")
}
                                                

// @LINE:634
def pasarCanceladoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/pasarCanceladoMasivo")
}
                                                

// @LINE:628
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/actualizar")
}
                                                

// @LINE:632
def pasarBorradorMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/pasarBorradorMasivo")
}
                                                

// @LINE:642
def getListaLicenciasPendientes(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/getListaLicenciasPendientes")
}
                                                

// @LINE:633
def modalPasarCancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/modalPasarCancelado")
}
                                                

// @LINE:638
def pasarAprobadoMasivo(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/pasarAprobadoMasivo")
}
                                                

// @LINE:626
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:625
def crear(agenteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("agenteId", agenteId)))))
}
                                                

// @LINE:635
def modalPasarPreAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-asistencia-licencia/modalPasarPreAprobado")
}
                                                
    
}
                          

// @LINE:1053
// @LINE:557
// @LINE:556
class ReverseCiesController {
    

// @LINE:1053
def suggestCie(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestCie/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:556
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/cie/modalBuscar")
}
                                                

// @LINE:557
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/cie/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:1033
// @LINE:602
// @LINE:589
// @LINE:586
// @LINE:585
// @LINE:584
// @LINE:583
// @LINE:582
// @LINE:581
// @LINE:580
// @LINE:579
// @LINE:578
class ReverseAgentesController {
    

// @LINE:582
def eliminarAgente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:589
def cambiarEstado(idAgente:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/cambiar-estado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idAgente", idAgente)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:602
def actualizarMail(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/actualizarMail")
}
                                                

// @LINE:580
def guardarAgente(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/guardar")
}
                                                

// @LINE:581
def editarAgente(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:579
def crearAgente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/crear")
}
                                                

// @LINE:583
def actualizarAgente(agenteId:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("agenteId", agenteId)))))
}
                                                

// @LINE:586
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:585
def get(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:584
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalBuscar")
}
                                                

// @LINE:1033
def suggestAgente(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestAgente/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:578
def indexAgente(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente")
}
                                                
    
}
                          

// @LINE:521
// @LINE:520
// @LINE:519
// @LINE:518
// @LINE:517
// @LINE:516
class ReverseAgentesNovedadesController {
    

// @LINE:516
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-novedad/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:521
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-novedad/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:519
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-novedad/guardar")
}
                                                

// @LINE:520
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-novedad/actualizar")
}
                                                

// @LINE:518
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-novedad/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:517
def crear(agenteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-novedad/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("agenteId", agenteId)))))
}
                                                
    
}
                          

// @LINE:535
// @LINE:534
// @LINE:533
// @LINE:532
// @LINE:531
// @LINE:530
class ReverseAgentesFamiliasController {
    

// @LINE:530
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-familia/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:535
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-familia/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:533
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-familia/guardar")
}
                                                

// @LINE:534
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente-familia/actualizar")
}
                                                

// @LINE:532
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-familia/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:531
def crear(agenteId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente-familia/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("agenteId", agenteId)))))
}
                                                
    
}
                          

// @LINE:600
// @LINE:599
// @LINE:598
// @LINE:597
// @LINE:596
// @LINE:595
// @LINE:594
// @LINE:593
// @LINE:592
// @LINE:591
// @LINE:588
// @LINE:587
class ReverseAgentesAccionesController {
    

// @LINE:588
def replicarProveedor(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/replicarProveedor")
}
                                                

// @LINE:596
def pasarACancelado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/pasarACancelado")
}
                                                

// @LINE:600
def pasarAPreaprobado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/pasarAPreaprobado")
}
                                                

// @LINE:597
def modalPasarACargado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalPasarACargado")
}
                                                

// @LINE:594
def pasarABorrador(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/pasarABorrador")
}
                                                

// @LINE:587
def modalReplicarProveedor(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalReplicarProveedor" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:598
def pasarACargado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/pasarACargado")
}
                                                

// @LINE:595
def modalPasarACancelado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalPasarACancelado")
}
                                                

// @LINE:591
def modalPasarAAprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalPasarAAprobado")
}
                                                

// @LINE:592
def pasarAAprobado(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agente/pasarAAprobado")
}
                                                

// @LINE:599
def modalPasarAPreaprobado(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalPasarAPreaprobado")
}
                                                

// @LINE:593
def modalPasarABorrador(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agente/modalPasarABorrador")
}
                                                
    
}
                          

// @LINE:1028
// @LINE:554
// @LINE:553
class ReverseProfesionesController {
    

// @LINE:553
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/profesion/modalBuscar")
}
                                                

// @LINE:1028
def suggestProfesion(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestProfesion/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:554
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/profesion/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:498
class ReverseIndexController {
    

// @LINE:498
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh")
}
                                                
    
}
                          

// @LINE:1026
// @LINE:542
// @LINE:541
// @LINE:540
// @LINE:539
// @LINE:538
// @LINE:537
// @LINE:500
// @LINE:499
class ReverseDepartamentosController {
    

// @LINE:500
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/departamento/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:539
def guardarDepartamento(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/departamento/guardar")
}
                                                

// @LINE:541
def eliminarDepartamento(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/departamento/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:540
def editarDepartamento(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/departamento/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:499
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/departamento/modalBuscar")
}
                                                

// @LINE:537
def indexDepartamento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/departamento")
}
                                                

// @LINE:1026
def suggestDepartamento(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestDepartamento/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:538
def crearDepartamento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/departamento/crear")
}
                                                

// @LINE:542
def actualizarDepartamento(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/departamento/actualizar")
}
                                                
    
}
                          

// @LINE:622
// @LINE:621
// @LINE:620
class ReverseAgentesAsistenciasController {
    

// @LINE:621
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteAsistencia/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:620
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteAsistencia/index")
}
                                                

// @LINE:622
def ver(id:Long, tipoLicencia:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteAsistencia/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(tipoLicencia == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("tipoLicencia", tipoLicencia)))))
}
                                                
    
}
                          

// @LINE:656
// @LINE:655
// @LINE:654
// @LINE:653
// @LINE:652
// @LINE:651
// @LINE:649
// @LINE:648
class ReverseAgentesSeguimientoController {
    

// @LINE:656
def cambiarEstado(idSeguimiento:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idSeguimiento", idSeguimiento)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:654
def actualizarAgenteSeguimiento(agenteId:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("agenteId", agenteId)))))
}
                                                

// @LINE:655
def eliminarAgenteSeguimiento(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:651
def crearAgenteSeguimiento(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/crear")
}
                                                

// @LINE:653
def editarAgenteSeguimiento(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:649
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:652
def guardarAgenteSeguimiento(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/guardar")
}
                                                

// @LINE:648
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/agenteSeguimiento/index")
}
                                                
    
}
                          

// @LINE:1030
// @LINE:576
// @LINE:575
// @LINE:574
// @LINE:573
// @LINE:572
// @LINE:571
// @LINE:570
// @LINE:569
class ReversePuestosController {
    

// @LINE:574
def actualizarPuesto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/puesto/actualizar")
}
                                                

// @LINE:569
def indexPuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/puesto")
}
                                                

// @LINE:576
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/puesto/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:575
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/puesto/modalBuscar")
}
                                                

// @LINE:1030
def suggestPuesto(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestPuesto/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:571
def guardarPuesto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "rrhh/puesto/guardar")
}
                                                

// @LINE:570
def crearPuesto(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/puesto/crear")
}
                                                

// @LINE:573
def eliminarPuesto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/puesto/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:572
def editarPuesto(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "rrhh/puesto/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          
}
                  

// @LINE:1054
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
package controllers {

// @LINE:1054
class ReverseAssets {
    

// @LINE:1054
def at(file:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                                                
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:15
class ReverseAuthentication {
    

// @LINE:17
def logout(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "logout")
}
                                                

// @LINE:16
def authenticate(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "login")
}
                                                

// @LINE:15
def login(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "login")
}
                                                
    
}
                          

// @LINE:13
class ReverseApplication {
    

// @LINE:13
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          
}
                  

// @LINE:1038
// @LINE:677
// @LINE:676
// @LINE:675
// @LINE:674
// @LINE:673
// @LINE:672
// @LINE:671
// @LINE:670
// @LINE:669
package controllers.delegacion {

// @LINE:1038
// @LINE:677
// @LINE:676
// @LINE:675
// @LINE:674
// @LINE:673
// @LINE:672
// @LINE:671
// @LINE:670
class ReverseDepositosController {
    

// @LINE:671
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion/deposito/crear")
}
                                                

// @LINE:677
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion/deposito/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:674
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion/deposito/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:672
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "delegacion/deposito/guardar")
}
                                                

// @LINE:675
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "delegacion/deposito/actualizar")
}
                                                

// @LINE:676
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion/deposito/modalBuscar")
}
                                                

// @LINE:1038
def suggestDeposito(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestDeposito/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:673
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion/deposito/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:670
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion/deposito")
}
                                                
    
}
                          

// @LINE:669
class ReverseIndexController {
    

// @LINE:669
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "delegacion")
}
                                                
    
}
                          
}
                  

// @LINE:1050
// @LINE:1032
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
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
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:22
// @LINE:21
package controllers.administracion {

// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
class ReverseUsuariosController {
    

// @LINE:33
def suggest(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios/suggest/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:28
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios/crear")
}
                                                

// @LINE:30
def editar(id:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios/editar" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                                                

// @LINE:35
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:29
def eliminar(id:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                                                

// @LINE:32
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "administracion/usuarios/guardar")
}
                                                

// @LINE:31
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "administracion/usuarios/actualizar")
}
                                                

// @LINE:34
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios/modalBuscar")
}
                                                

// @LINE:27
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/usuarios")
}
                                                
    
}
                          

// @LINE:1050
// @LINE:22
// @LINE:21
class ReverseOrganigramasController {
    

// @LINE:21
def modalBuscarServicios(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/organigrama/modal-buscar-sevicios")
}
                                                

// @LINE:22
def get(id:Long = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/organigrama/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:1050
def suggestOrganigrama(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestOrganigrama/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                
    
}
                          

// @LINE:38
// @LINE:37
// @LINE:36
class ReversePermisosController {
    

// @LINE:38
def desasignar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/desasignar")
}
                                                

// @LINE:36
def index(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/permisos" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:37
def asignar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/asignar")
}
                                                
    
}
                          

// @LINE:39
class ReverseProvinciasController {
    

// @LINE:39
def listOptions(paisId:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/provincias/listOptions" + queryString(List(if(paisId == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("paisId", paisId)))))
}
                                                
    
}
                          

// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
class ReverseTicketsController {
    

// @LINE:56
def cambiarEstado(id:Long, estado_id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/tickets/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), Some(implicitly[QueryStringBindable[Long]].unbind("estado_id", estado_id)))))
}
                                                

// @LINE:52
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/tickets/crear")
}
                                                

// @LINE:57
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/tickets/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:58
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/tickets/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:53
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "administracion/tickets/guardar")
}
                                                

// @LINE:55
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "administracion/tickets/actualizar")
}
                                                

// @LINE:54
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/tickets/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:51
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/tickets")
}
                                                
    
}
                          

// @LINE:26
class ReverseIndexController {
    

// @LINE:26
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion")
}
                                                
    
}
                          

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
class ReverseGruposController {
    

// @LINE:42
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/grupos/crear")
}
                                                

// @LINE:44
def editar(id:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/grupos/editar" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                                                

// @LINE:48
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/grupos/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:43
def eliminar(id:Integer): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/grupos/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Integer]].unbind("id", id)))))
}
                                                

// @LINE:46
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "administracion/grupos/guardar")
}
                                                

// @LINE:45
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "administracion/grupos/actualizar")
}
                                                

// @LINE:47
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/grupos/modalBuscar")
}
                                                

// @LINE:41
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/grupos")
}
                                                
    
}
                          

// @LINE:1032
// @LINE:40
class ReverseLocalidadesController {
    

// @LINE:1032
def suggestLocalidad(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestLocalidad/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:40
def listOptions(provinciaId:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "administracion/localidades/listOptions" + queryString(List(if(provinciaId == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("provinciaId", provinciaId)))))
}
                                                
    
}
                          
}
                  


// @LINE:1052
// @LINE:1042
// @LINE:1025
// @LINE:494
// @LINE:493
// @LINE:492
// @LINE:491
// @LINE:490
// @LINE:489
// @LINE:488
// @LINE:487
// @LINE:486
// @LINE:485
// @LINE:484
// @LINE:482
// @LINE:481
// @LINE:480
// @LINE:479
// @LINE:478
// @LINE:477
// @LINE:476
// @LINE:474
// @LINE:473
// @LINE:472
// @LINE:471
// @LINE:470
// @LINE:469
// @LINE:467
// @LINE:466
// @LINE:465
// @LINE:464
// @LINE:463
// @LINE:462
// @LINE:460
// @LINE:459
// @LINE:458
// @LINE:457
// @LINE:456
// @LINE:455
// @LINE:454
// @LINE:453
// @LINE:452
// @LINE:451
// @LINE:450
// @LINE:449
// @LINE:448
// @LINE:447
// @LINE:446
// @LINE:445
// @LINE:444
// @LINE:443
// @LINE:442
// @LINE:441
// @LINE:439
// @LINE:438
// @LINE:437
// @LINE:436
// @LINE:435
// @LINE:434
// @LINE:433
// @LINE:432
// @LINE:431
// @LINE:430
package controllers.expediente.javascript {

// @LINE:1052
// @LINE:1042
// @LINE:460
// @LINE:459
// @LINE:458
// @LINE:457
// @LINE:456
// @LINE:455
// @LINE:454
// @LINE:453
// @LINE:452
// @LINE:451
// @LINE:450
// @LINE:449
// @LINE:448
// @LINE:447
// @LINE:446
// @LINE:445
// @LINE:444
// @LINE:443
// @LINE:442
// @LINE:441
class ReverseExpedientesController {
    

// @LINE:449
def modalBuscarCopia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.modalBuscarCopia",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/modalBuscarCopia"})
      }
   """
)
                        

// @LINE:453
def reporteTapaExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.reporteTapaExpediente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reporteTapaExpediente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:452
def reporteTapaExpedienteMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.reporteTapaExpedienteMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reporteTapaExpedienteMasiva"})
      }
   """
)
                        

// @LINE:444
def editarExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.editarExpediente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1052
def suggestExpedienteCopia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.suggestExpedienteCopia",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestExpedienteCopia/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:442
def crearExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.crearExpediente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/crear"})
      }
   """
)
                        

// @LINE:455
def crearCopia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.crearCopia",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/crearCopia" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:450
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:451
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:454
def listadoExpedientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.listadoExpedientes",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reporteListadoExpedientes"})
      }
   """
)
                        

// @LINE:459
def getExpedientesSinFirma : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.getExpedientesSinFirma",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/getExpedientesSinFirma"})
      }
   """
)
                        

// @LINE:1042
def suggestExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.suggestExpediente",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestExpediente/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:458
def getExpedientesRecepcionSinFirmaReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirmaReporte",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/getExpedientesRecepcionSinFirmaReporte"})
      }
   """
)
                        

// @LINE:448
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/modalBuscar"})
      }
   """
)
                        

// @LINE:443
def guardarExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.guardarExpediente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/guardar"})
      }
   """
)
                        

// @LINE:445
def eliminarExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.eliminarExpediente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:457
def getExpedientesRecepcionSinFirma : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirma",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/getExpedientesRecepcionSinFirma"})
      }
   """
)
                        

// @LINE:447
def actualizarExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.actualizarExpediente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/actualizar"})
      }
   """
)
                        

// @LINE:456
def crearRP : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.crearRP",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/crearRP" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:460
def getExpedientesSinFirmaReporte : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.getExpedientesSinFirmaReporte",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/getExpedientesSinFirmaReporte"})
      }
   """
)
                        

// @LINE:441
def indexExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.indexExpediente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente"})
      }
   """
)
                        

// @LINE:446
def eliminarExpedienteCopia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesController.eliminarExpedienteCopia",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expediente/eliminarCopia" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:494
// @LINE:493
// @LINE:492
// @LINE:491
// @LINE:490
// @LINE:489
// @LINE:488
// @LINE:487
// @LINE:486
// @LINE:485
// @LINE:484
class ReverseDisposController {
    

// @LINE:493
def getDisposPorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.getDisposPorExpediente",
   """
      function(expedienteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/getDisposPorExpediente" + _qS([(expedienteId == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("expedienteId", expedienteId))])})
      }
   """
)
                        

// @LINE:494
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.cambiarEstado",
   """
      function(idDispo,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idDispo", idDispo), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:485
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/crear"})
      }
   """
)
                        

// @LINE:492
def getLastNumeroDispoByOrden : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.getLastNumeroDispoByOrden",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/getLastNumeroDispoByOrden"})
      }
   """
)
                        

// @LINE:490
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:489
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:491
def getLastNumeroDispo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.getLastNumeroDispo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/getLastNumeroDispo"})
      }
   """
)
                        

// @LINE:486
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/guardar"})
      }
   """
)
                        

// @LINE:488
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/actualizar"})
      }
   """
)
                        

// @LINE:487
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:484
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.DisposController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/dispo"})
      }
   """
)
                        
    
}
              

// @LINE:1025
// @LINE:438
// @LINE:437
// @LINE:436
// @LINE:435
// @LINE:434
// @LINE:433
// @LINE:432
// @LINE:431
class ReverseIniciadorExpedientesController {
    

// @LINE:435
def eliminarIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.eliminarIniciadorExpediente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expedient/iniciadorExpediente/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:436
def actualizarIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.actualizarIniciadorExpediente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente/actualizar"})
      }
   """
)
                        

// @LINE:1025
def suggestIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.suggestIniciadorExpediente",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestIniciador/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:438
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:433
def guardarIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.guardarIniciadorExpediente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente/guardar"})
      }
   """
)
                        

// @LINE:432
def crearIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.crearIniciadorExpediente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente/crear"})
      }
   """
)
                        

// @LINE:437
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente/modalBuscar"})
      }
   """
)
                        

// @LINE:434
def editarIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.editarIniciadorExpediente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:431
def indexIniciadorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IniciadorExpedientesController.indexIniciadorExpediente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/iniciadorExpediente"})
      }
   """
)
                        
    
}
              

// @LINE:430
class ReverseIndexController {
    

// @LINE:430
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente"})
      }
   """
)
                        
    
}
              

// @LINE:467
// @LINE:466
// @LINE:465
// @LINE:464
// @LINE:463
// @LINE:462
class ReverseExpedientesMovimientosController {
    

// @LINE:462
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMovimientosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/movimiento-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:467
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMovimientosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/movimiento-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:465
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMovimientosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/movimiento-linea/guardar"})
      }
   """
)
                        

// @LINE:466
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMovimientosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/movimiento-linea/actualizar"})
      }
   """
)
                        

// @LINE:464
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMovimientosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/movimiento-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:463
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMovimientosController.crear",
   """
      function(expedienteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/movimiento-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("expedienteId", expedienteId)])})
      }
   """
)
                        
    
}
              

// @LINE:476
// @LINE:474
// @LINE:473
// @LINE:472
// @LINE:439
class ReverseExpedientesReportesController {
    

// @LINE:476
def reportePaseExpedienteLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesReportesController.reportePaseExpedienteLista",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reportes/reportePaseExpedienteLista"})
      }
   """
)
                        

// @LINE:472
def reportePaseExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesReportesController.reportePaseExpediente",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reportes/reportePaseExpediente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:439
def reporteMovimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesReportesController.reporteMovimiento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reportes/reporteMovimiento"})
      }
   """
)
                        

// @LINE:474
def reportePaseExpedienteListaCodigo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigo",
   """
      function(codigo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reportes/reportePaseExpedienteCodigo" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("codigo", codigo)])})
      }
   """
)
                        

// @LINE:473
def reportePaseExpedienteListaCodigoCombinado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigoCombinado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/reportes/reportePaseExpedienteLista"})
      }
   """
)
                        
    
}
              

// @LINE:480
class ReverseExpedientesMisPasesController {
    

// @LINE:480
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesMisPasesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/expedienteMisPases"})
      }
   """
)
                        
    
}
              

// @LINE:482
// @LINE:481
// @LINE:479
// @LINE:478
// @LINE:477
// @LINE:471
// @LINE:470
// @LINE:469
class ReverseExpedientesAccionesController {
    

// @LINE:477
def cancelarPase : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.cancelarPase",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/cancelarPase" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:470
def modalPasarOtroServicioIndividual : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicioIndividual",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/modalPasarOtroServicioIndividual" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:479
def asignarMiServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.asignarMiServicio",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/asignarMiServicio" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:471
def pasarOtroServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.pasarOtroServicio",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/pasarOtroServicio"})
      }
   """
)
                        

// @LINE:478
def cancelarPaseLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.cancelarPaseLista",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/cancelarPaseLista"})
      }
   """
)
                        

// @LINE:469
def modalPasarOtroServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicio",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/modalPasarOtroServicio"})
      }
   """
)
                        

// @LINE:482
def modalAsignarMiServicio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.modalAsignarMiServicio",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/modalAsignarMiServicio"})
      }
   """
)
                        

// @LINE:481
def asignarAMiServicioMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.expediente.ExpedientesAccionesController.asignarAMiServicioMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "expediente/acciones/asignarMiServicioMasivo"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:729
// @LINE:728
// @LINE:726
// @LINE:725
// @LINE:722
// @LINE:721
// @LINE:720
// @LINE:718
// @LINE:716
// @LINE:715
// @LINE:714
// @LINE:713
// @LINE:711
// @LINE:710
// @LINE:709
// @LINE:708
// @LINE:707
// @LINE:706
// @LINE:705
// @LINE:704
// @LINE:703
// @LINE:702
// @LINE:701
// @LINE:700
// @LINE:699
// @LINE:698
// @LINE:697
// @LINE:695
// @LINE:693
// @LINE:691
// @LINE:690
// @LINE:689
// @LINE:687
// @LINE:686
// @LINE:685
// @LINE:684
// @LINE:683
// @LINE:682
// @LINE:681
package controllers.presupuesto.javascript {

// @LINE:709
// @LINE:708
// @LINE:707
// @LINE:706
// @LINE:705
// @LINE:704
class ReverseLineasRecursosPresupuestariosController {
    

// @LINE:704
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasRecursosPresupuestariosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-recurso/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:709
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasRecursosPresupuestariosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-recurso/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:707
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasRecursosPresupuestariosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-recurso/guardar"})
      }
   """
)
                        

// @LINE:708
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasRecursosPresupuestariosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-recurso/actualizar"})
      }
   """
)
                        

// @LINE:706
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasRecursosPresupuestariosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-recurso/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:705
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasRecursosPresupuestariosController.crear",
   """
      function(creditoPresupuestarioId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-recurso/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("creditoPresupuestarioId", creditoPresupuestarioId)])})
      }
   """
)
                        
    
}
              

// @LINE:703
// @LINE:702
// @LINE:701
// @LINE:700
// @LINE:699
// @LINE:698
class ReverseLineasCreditosPresupuestariosController {
    

// @LINE:698
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasCreditosPresupuestariosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-credito/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:703
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasCreditosPresupuestariosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-credito/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:701
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasCreditosPresupuestariosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-credito/guardar"})
      }
   """
)
                        

// @LINE:702
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasCreditosPresupuestariosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-credito/actualizar"})
      }
   """
)
                        

// @LINE:700
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasCreditosPresupuestariosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-credito/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:699
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.LineasCreditosPresupuestariosController.crear",
   """
      function(creditoPresupuestarioId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/linea-credito/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("creditoPresupuestarioId", creditoPresupuestarioId)])})
      }
   """
)
                        
    
}
              

// @LINE:711
// @LINE:710
class ReverseBalancePresupuestarioController {
    

// @LINE:711
def balancePresupuestarioPorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioController.balancePresupuestarioPorExpediente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/balancePresupuestarioPorExpediente"})
      }
   """
)
                        

// @LINE:710
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/balance-presupuestario"})
      }
   """
)
                        
    
}
              

// @LINE:697
// @LINE:695
// @LINE:693
// @LINE:691
// @LINE:690
// @LINE:689
// @LINE:687
// @LINE:686
// @LINE:685
// @LINE:684
// @LINE:683
// @LINE:682
class ReverseCreditosPresupuestariosController {
    

// @LINE:691
def aprobar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.aprobar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/aprobar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:693
def listaCargas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.listaCargas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-listaCargas"})
      }
   """
)
                        

// @LINE:683
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/crear"})
      }
   """
)
                        

// @LINE:689
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:690
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:686
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:684
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/guardar"})
      }
   """
)
                        

// @LINE:687
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/actualizar"})
      }
   """
)
                        

// @LINE:685
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:697
def reporteListadoCreditos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.reporteListadoCreditos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario/reporteListadoCreditos"})
      }
   """
)
                        

// @LINE:695
// @LINE:682
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.CreditosPresupuestariosController.index",
   """
      function() {
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario"})
      }
      if (true) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/credito-presupuestario"})
      }
      }
   """
)
                        
    
}
              

// @LINE:681
class ReverseIndexController {
    

// @LINE:681
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto"})
      }
   """
)
                        
    
}
              

// @LINE:729
// @LINE:728
// @LINE:726
// @LINE:725
class ReverseControlPresupuestarioController {
    

// @LINE:729
def movimientosSaldoPreventivoExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivoExcel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/movimientosSaldoPreventivoExcel"})
      }
   """
)
                        

// @LINE:728
def movimientosSaldoPreventivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/movimientosSaldoPreventivo"})
      }
   """
)
                        

// @LINE:726
def controlAnulacionProductosAutomaticosExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticosExcel",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/controlAnulacionProductosAutomaticosExcel"})
      }
   """
)
                        

// @LINE:725
def controlAnulacionProductosAutomaticos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/controlAnulacionProductosAutomaticos"})
      }
   """
)
                        
    
}
              

// @LINE:722
// @LINE:721
// @LINE:720
// @LINE:718
// @LINE:716
// @LINE:715
// @LINE:714
// @LINE:713
class ReverseBalancePresupuestarioReportesController {
    

// @LINE:715
def modalReporteExportarDatosPresupuestoControl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteExportarDatosPresupuestoControl",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporte/modalReporteExportarDatosPresupuestoControl"})
      }
   """
)
                        

// @LINE:718
def reporteBalanceDiferenciaPreventivoDefinitivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo",
   """
      function(idEjercicio) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporte/reporteBalanceDiferenciaPreventivoDefinitivo" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEjercicio", idEjercicio)])})
      }
   """
)
                        

// @LINE:716
def reporteExportarDatosPresupuestoControl : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.reporteExportarDatosPresupuestoControl",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporte/reporteExportarDatosPresupuestoControl"})
      }
   """
)
                        

// @LINE:713
def modalReporteBalancePorCuentaPorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorCuentaPorExpediente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporte/modalReporteBalancePorCuentaPorExpediente" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:721
def reporteBalancePorFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFecha",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporteBalancePorFecha"})
      }
   """
)
                        

// @LINE:714
def reporteBalancePorCuentaPorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorCuentaPorExpediente",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporte/reporteBalancePorCuentaPorExpediente" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:720
def modalReporteBalancePorFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorFecha",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/modalReporteBalancePorFecha"})
      }
   """
)
                        

// @LINE:722
def reporteBalancePorFechaPorExpediente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFechaPorExpediente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto/reporteBalancePorFechaPorExpediente"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:1048
// @LINE:1047
// @LINE:1046
// @LINE:1018
// @LINE:1012
// @LINE:1010
// @LINE:1009
// @LINE:1008
// @LINE:1006
// @LINE:1005
// @LINE:1004
// @LINE:1003
// @LINE:1002
// @LINE:1001
// @LINE:1000
// @LINE:998
// @LINE:997
// @LINE:996
// @LINE:995
// @LINE:994
// @LINE:993
// @LINE:992
// @LINE:991
// @LINE:990
// @LINE:988
// @LINE:987
// @LINE:986
// @LINE:985
// @LINE:984
// @LINE:983
// @LINE:982
// @LINE:981
// @LINE:980
// @LINE:979
// @LINE:978
// @LINE:977
// @LINE:976
// @LINE:975
// @LINE:974
// @LINE:973
// @LINE:972
// @LINE:971
// @LINE:970
// @LINE:969
// @LINE:968
// @LINE:967
// @LINE:966
// @LINE:965
// @LINE:964
// @LINE:963
// @LINE:962
// @LINE:961
// @LINE:960
// @LINE:957
// @LINE:956
// @LINE:954
// @LINE:953
// @LINE:952
// @LINE:951
// @LINE:950
// @LINE:949
// @LINE:948
// @LINE:947
// @LINE:946
// @LINE:944
// @LINE:943
// @LINE:942
// @LINE:941
// @LINE:940
// @LINE:939
// @LINE:938
// @LINE:937
// @LINE:936
// @LINE:934
// @LINE:933
// @LINE:932
// @LINE:931
// @LINE:930
// @LINE:929
// @LINE:928
// @LINE:927
// @LINE:926
// @LINE:924
// @LINE:923
// @LINE:922
// @LINE:921
// @LINE:920
// @LINE:919
// @LINE:918
// @LINE:917
// @LINE:916
// @LINE:915
// @LINE:913
// @LINE:912
// @LINE:911
// @LINE:910
// @LINE:909
// @LINE:908
// @LINE:907
// @LINE:906
// @LINE:905
// @LINE:903
// @LINE:902
// @LINE:901
// @LINE:900
// @LINE:899
// @LINE:898
// @LINE:897
// @LINE:896
// @LINE:895
// @LINE:893
// @LINE:892
// @LINE:891
// @LINE:890
// @LINE:889
// @LINE:888
// @LINE:886
// @LINE:885
// @LINE:884
// @LINE:883
// @LINE:882
// @LINE:881
// @LINE:880
// @LINE:879
// @LINE:878
// @LINE:877
// @LINE:875
// @LINE:874
// @LINE:872
// @LINE:871
// @LINE:870
// @LINE:869
// @LINE:868
// @LINE:867
// @LINE:866
// @LINE:865
// @LINE:864
// @LINE:863
// @LINE:862
// @LINE:861
// @LINE:860
// @LINE:859
// @LINE:858
// @LINE:856
// @LINE:855
// @LINE:854
// @LINE:853
// @LINE:852
// @LINE:851
// @LINE:850
// @LINE:849
// @LINE:848
// @LINE:847
// @LINE:845
// @LINE:844
// @LINE:843
// @LINE:842
// @LINE:841
// @LINE:840
// @LINE:839
// @LINE:838
// @LINE:837
// @LINE:835
// @LINE:834
// @LINE:833
// @LINE:832
// @LINE:831
// @LINE:830
// @LINE:829
// @LINE:828
// @LINE:827
// @LINE:825
// @LINE:824
// @LINE:823
// @LINE:822
// @LINE:821
// @LINE:820
// @LINE:819
// @LINE:818
// @LINE:817
// @LINE:815
// @LINE:814
// @LINE:813
// @LINE:812
// @LINE:811
// @LINE:810
// @LINE:809
// @LINE:808
// @LINE:807
// @LINE:805
// @LINE:804
// @LINE:803
// @LINE:802
// @LINE:801
// @LINE:800
// @LINE:799
// @LINE:798
// @LINE:797
// @LINE:795
// @LINE:794
// @LINE:793
// @LINE:792
// @LINE:791
// @LINE:790
// @LINE:789
// @LINE:788
// @LINE:787
// @LINE:784
// @LINE:783
// @LINE:781
// @LINE:780
// @LINE:778
// @LINE:777
// @LINE:776
// @LINE:775
// @LINE:774
// @LINE:773
// @LINE:772
// @LINE:771
// @LINE:770
// @LINE:766
// @LINE:765
// @LINE:764
// @LINE:763
// @LINE:762
// @LINE:761
// @LINE:760
// @LINE:759
// @LINE:758
// @LINE:757
// @LINE:756
// @LINE:753
// @LINE:752
// @LINE:750
// @LINE:749
// @LINE:748
// @LINE:747
// @LINE:746
// @LINE:745
// @LINE:744
// @LINE:743
// @LINE:742
package controllers.haberes.javascript {

// @LINE:795
// @LINE:794
// @LINE:793
// @LINE:792
// @LINE:791
// @LINE:790
// @LINE:789
// @LINE:788
// @LINE:787
class ReversePuestosLaboralesReportesController {
    

// @LINE:788
def altasMacroSueldo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.altasMacroSueldo",
   """
      function(nuevo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/reportes/alta-macrosueldo" + _qS([(nuevo == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("nuevo", nuevo))])})
      }
   """
)
                        

// @LINE:795
def formulario6492022 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.formulario6492022",
   """
      function(id,ejercicio_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reportes/formulario649-2022" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("ejercicio_id", ejercicio_id)])})
      }
   """
)
                        

// @LINE:790
def listadoPuestosLaborales : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.listadoPuestosLaborales",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/reportes/listado"})
      }
   """
)
                        

// @LINE:787
def altasMasivas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.altasMasivas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/reportes/alta-masiva"})
      }
   """
)
                        

// @LINE:792
def formulario649 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.formulario649",
   """
      function(id,ejercicio_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reportes/formulario649" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("ejercicio_id", ejercicio_id)])})
      }
   """
)
                        

// @LINE:794
def formulario6492021 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.formulario6492021",
   """
      function(id,ejercicio_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reportes/formulario649-2021" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("ejercicio_id", ejercicio_id)])})
      }
   """
)
                        

// @LINE:793
def formulario6492019 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.formulario6492019",
   """
      function(id,ejercicio_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reportes/formulario649-2019" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("ejercicio_id", ejercicio_id)])})
      }
   """
)
                        

// @LINE:791
def reportef649 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.reportef649",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/reportes/f649"})
      }
   """
)
                        

// @LINE:789
def descargarArchivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesReportesController.descargarArchivo",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/reportes/descargar-archivo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url)])})
      }
   """
)
                        
    
}
              

// @LINE:856
// @LINE:855
// @LINE:854
// @LINE:853
// @LINE:852
// @LINE:851
// @LINE:850
// @LINE:849
// @LINE:848
// @LINE:847
class ReverseCategoriasLaboralesController {
    

// @LINE:848
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/crear"})
      }
   """
)
                        

// @LINE:854
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:855
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:851
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:849
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/guardar"})
      }
   """
)
                        

// @LINE:852
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/actualizar"})
      }
   """
)
                        

// @LINE:853
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/modalBuscar"})
      }
   """
)
                        

// @LINE:856
def suggestCategoriaLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.suggestCategoriaLaboral",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/suggestCategoriaLaboral/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:850
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:847
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CategoriasLaboralesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/categoriaLaboral"})
      }
   """
)
                        
    
}
              

// @LINE:954
// @LINE:953
// @LINE:952
// @LINE:951
// @LINE:950
// @LINE:949
// @LINE:948
// @LINE:947
// @LINE:946
class ReverseInstrumentosLegalesController {
    

// @LINE:947
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/crear"})
      }
   """
)
                        

// @LINE:953
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:954
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:950
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:948
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/guardar"})
      }
   """
)
                        

// @LINE:951
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/actualizar"})
      }
   """
)
                        

// @LINE:952
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/modalBuscar"})
      }
   """
)
                        

// @LINE:949
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:946
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.InstrumentosLegalesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/instrumento"})
      }
   """
)
                        
    
}
              

// @LINE:1006
// @LINE:1005
// @LINE:1004
// @LINE:1003
// @LINE:1002
// @LINE:1001
// @LINE:1000
class ReverseEscalasLaboralesMontosController {
    

// @LINE:1001
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto/crear"})
      }
   """
)
                        

// @LINE:1006
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1004
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1002
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto/guardar"})
      }
   """
)
                        

// @LINE:1005
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto/actualizar"})
      }
   """
)
                        

// @LINE:1003
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1000
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesMontosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboralMonto"})
      }
   """
)
                        
    
}
              

// @LINE:872
// @LINE:870
// @LINE:866
// @LINE:865
// @LINE:864
// @LINE:863
// @LINE:862
// @LINE:861
// @LINE:860
// @LINE:859
// @LINE:858
class ReverseLiquidacionPuestosController {
    

// @LINE:870
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.cambiarEstado",
   """
      function(idLiquidacionPuesto,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idLiquidacionPuesto", idLiquidacionPuesto), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:859
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/crear"})
      }
   """
)
                        

// @LINE:872
def preLiquidar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.preLiquidar",
   """
      function(idPuestoLaboral,idLiquidacionMes,idLiquidacionPuesto) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/preliquidar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPuestoLaboral", idPuestoLaboral), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idLiquidacionMes", idLiquidacionMes), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idLiquidacionPuesto", idLiquidacionPuesto)])})
      }
   """
)
                        

// @LINE:865
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:866
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:862
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:860
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/guardar"})
      }
   """
)
                        

// @LINE:863
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/actualizar"})
      }
   """
)
                        

// @LINE:864
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/modalBuscar"})
      }
   """
)
                        

// @LINE:861
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:858
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto"})
      }
   """
)
                        
    
}
              

// @LINE:944
// @LINE:943
// @LINE:942
// @LINE:941
// @LINE:940
// @LINE:939
// @LINE:938
// @LINE:937
// @LINE:936
class ReverseLegajosController {
    

// @LINE:937
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/crear"})
      }
   """
)
                        

// @LINE:943
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:944
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:940
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:938
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/guardar"})
      }
   """
)
                        

// @LINE:941
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/actualizar"})
      }
   """
)
                        

// @LINE:942
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/modalBuscar"})
      }
   """
)
                        

// @LINE:939
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:936
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LegajosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/legajo"})
      }
   """
)
                        
    
}
              

// @LINE:825
// @LINE:824
// @LINE:823
// @LINE:822
// @LINE:821
// @LINE:820
// @LINE:819
// @LINE:818
// @LINE:817
class ReverseLiquidacionBaseCalculosController {
    

// @LINE:818
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/crear"})
      }
   """
)
                        

// @LINE:824
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:825
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:821
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:819
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/guardar"})
      }
   """
)
                        

// @LINE:822
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/actualizar"})
      }
   """
)
                        

// @LINE:823
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/modalBuscar"})
      }
   """
)
                        

// @LINE:820
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:817
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionBaseCalculosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionBaseCalculo"})
      }
   """
)
                        
    
}
              

// @LINE:934
// @LINE:933
// @LINE:932
// @LINE:931
// @LINE:930
// @LINE:929
// @LINE:928
// @LINE:927
// @LINE:926
class ReverseConveniosBancosController {
    

// @LINE:927
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/crear"})
      }
   """
)
                        

// @LINE:933
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:934
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:930
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:928
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/guardar"})
      }
   """
)
                        

// @LINE:931
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/actualizar"})
      }
   """
)
                        

// @LINE:932
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/modalBuscar"})
      }
   """
)
                        

// @LINE:929
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:926
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.ConveniosBancosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/convenioBanco"})
      }
   """
)
                        
    
}
              

// @LINE:1046
// @LINE:805
// @LINE:804
// @LINE:803
// @LINE:802
// @LINE:801
// @LINE:800
// @LINE:799
// @LINE:798
// @LINE:797
class ReverseLiquidacionConceptosController {
    

// @LINE:798
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/crear"})
      }
   """
)
                        

// @LINE:804
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:805
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:801
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:799
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/guardar"})
      }
   """
)
                        

// @LINE:802
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/actualizar"})
      }
   """
)
                        

// @LINE:803
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/modalBuscar"})
      }
   """
)
                        

// @LINE:1046
def suggestLiquidacionConceptoTipo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.suggestLiquidacionConceptoTipo",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestConcepto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:800
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:797
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConcepto"})
      }
   """
)
                        
    
}
              

// @LINE:886
// @LINE:885
// @LINE:884
// @LINE:883
// @LINE:882
// @LINE:881
// @LINE:880
// @LINE:879
// @LINE:878
// @LINE:877
class ReverseLiquidacionPuestosAccionesController {
    

// @LINE:883
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:881
def modalPasarPreaprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.modalPasarPreaprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/modalPasarPreaprobado"})
      }
   """
)
                        

// @LINE:877
def modalPasarAOtraLiquidacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAOtraLiquidacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/modalPasarAOtraLiquidacion"})
      }
   """
)
                        

// @LINE:882
def pasarPreaprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.pasarPreaprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/pasarPreaprobadoMasivo"})
      }
   """
)
                        

// @LINE:879
def modalPasarAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/modalPasarAprobado"})
      }
   """
)
                        

// @LINE:886
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:884
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:885
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:880
def pasarAprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.pasarAprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/pasarEnCursoMasivo"})
      }
   """
)
                        

// @LINE:878
def pasarAOtraLiquidacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosAccionesController.pasarAOtraLiquidacion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/pasarAOtraLiquidacion"})
      }
   """
)
                        
    
}
              

// @LINE:835
// @LINE:834
// @LINE:833
// @LINE:832
// @LINE:831
// @LINE:830
// @LINE:829
// @LINE:828
// @LINE:827
class ReverseLiquidacionTiposController {
    

// @LINE:828
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/crear"})
      }
   """
)
                        

// @LINE:834
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:835
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:831
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:829
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/guardar"})
      }
   """
)
                        

// @LINE:832
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/actualizar"})
      }
   """
)
                        

// @LINE:833
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/modalBuscar"})
      }
   """
)
                        

// @LINE:830
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:827
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionTiposController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionTipo"})
      }
   """
)
                        
    
}
              

// @LINE:750
// @LINE:749
// @LINE:748
// @LINE:747
// @LINE:746
// @LINE:745
// @LINE:744
// @LINE:743
class ReverseNovedadesController {
    

// @LINE:746
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/crear"})
      }
   """
)
                        

// @LINE:745
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:750
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:747
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/guardar"})
      }
   """
)
                        

// @LINE:749
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/actualizar"})
      }
   """
)
                        

// @LINE:744
def lista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.lista",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/lista"})
      }
   """
)
                        

// @LINE:748
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:743
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades"})
      }
   """
)
                        
    
}
              

// @LINE:903
// @LINE:902
// @LINE:901
// @LINE:900
// @LINE:899
// @LINE:898
// @LINE:897
// @LINE:896
// @LINE:895
class ReverseCargosLaboralesController {
    

// @LINE:896
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/crear"})
      }
   """
)
                        

// @LINE:902
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:903
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:899
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:897
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/guardar"})
      }
   """
)
                        

// @LINE:900
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/actualizar"})
      }
   """
)
                        

// @LINE:901
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/modalBuscar"})
      }
   """
)
                        

// @LINE:898
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:895
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CargosLaboralesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/cargoLaboral"})
      }
   """
)
                        
    
}
              

// @LINE:753
// @LINE:752
class ReverseNovedadesAccionesController {
    

// @LINE:752
def crearMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesAccionesController.crearMasivo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/acciones/crear-masivo"})
      }
   """
)
                        

// @LINE:753
def procesarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.NovedadesAccionesController.procesarMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/novedades/acciones/procesar-masivo"})
      }
   """
)
                        
    
}
              

// @LINE:845
// @LINE:844
// @LINE:843
// @LINE:842
// @LINE:841
// @LINE:840
// @LINE:839
// @LINE:838
// @LINE:837
class ReverseUnidadesLaboralesController {
    

// @LINE:838
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/crear"})
      }
   """
)
                        

// @LINE:844
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:845
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:841
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:839
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/guardar"})
      }
   """
)
                        

// @LINE:842
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/actualizar"})
      }
   """
)
                        

// @LINE:843
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/modalBuscar"})
      }
   """
)
                        

// @LINE:840
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:837
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.UnidadesLaboralesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/unidadLaboral"})
      }
   """
)
                        
    
}
              

// @LINE:997
// @LINE:996
// @LINE:995
// @LINE:994
// @LINE:993
// @LINE:992
// @LINE:991
// @LINE:990
class ReverseLiquidacionAccionesController {
    

// @LINE:992
def exportBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.exportBanco",
   """
      function(liquidacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/exportBanco" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("liquidacionId", liquidacionId)])})
      }
   """
)
                        

// @LINE:995
def descargarAfip : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.descargarAfip",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/descargarAfip" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url)])})
      }
   """
)
                        

// @LINE:997
def descargarIps : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.descargarIps",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/descargarIps" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url)])})
      }
   """
)
                        

// @LINE:991
def exportMacroSueldos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.exportMacroSueldos",
   """
      function(liquidacionId,nuevo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/exportMacroSueldos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("liquidacionId", liquidacionId), (nuevo == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("nuevo", nuevo))])})
      }
   """
)
                        

// @LINE:996
def exportIps : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.exportIps",
   """
      function(liquidacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/exportIps" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("liquidacionId", liquidacionId)])})
      }
   """
)
                        

// @LINE:993
def descargarBanco : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.descargarBanco",
   """
      function(url) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/descargarBanco" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("url", url)])})
      }
   """
)
                        

// @LINE:990
def exportMacroSueldosLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.exportMacroSueldosLista",
   """
      function(nuevo) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/exportMacroSueldosLista" + _qS([(nuevo == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("nuevo", nuevo))])})
      }
   """
)
                        

// @LINE:994
def exportAfip : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionAccionesController.exportAfip",
   """
      function(liquidacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/exportAfip" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("liquidacionId", liquidacionId)])})
      }
   """
)
                        
    
}
              

// @LINE:1018
// @LINE:984
// @LINE:967
// @LINE:966
// @LINE:965
// @LINE:964
// @LINE:963
// @LINE:962
// @LINE:961
// @LINE:960
// @LINE:957
// @LINE:956
class ReverseLiquidacionMesesController {
    

// @LINE:984
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.cambiarEstado",
   """
      function(idLiquidacion,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idLiquidacion", idLiquidacion), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:957
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/crear"})
      }
   """
)
                        

// @LINE:965
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:967
def preliquidar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.preliquidar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/preliquidar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:966
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:962
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:960
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/guardar"})
      }
   """
)
                        

// @LINE:963
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/actualizar"})
      }
   """
)
                        

// @LINE:964
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/modalBuscar"})
      }
   """
)
                        

// @LINE:1018
def suggestLiquidacionMes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.suggestLiquidacionMes",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestLiquidacionMes/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:961
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:956
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes"})
      }
   """
)
                        
    
}
              

// @LINE:1012
class ReversePrestaFacilController {
    

// @LINE:1012
def enviarArchivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PrestaFacilController.enviarArchivo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/prestaFacil/enviarArchivo"})
      }
   """
)
                        
    
}
              

// @LINE:815
// @LINE:814
// @LINE:813
// @LINE:812
// @LINE:811
// @LINE:810
// @LINE:809
// @LINE:808
// @LINE:807
class ReverseLiquidacionConceptoTiposController {
    

// @LINE:808
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/crear"})
      }
   """
)
                        

// @LINE:814
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:815
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:811
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:809
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/guardar"})
      }
   """
)
                        

// @LINE:812
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/actualizar"})
      }
   """
)
                        

// @LINE:813
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/modalBuscar"})
      }
   """
)
                        

// @LINE:810
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:807
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionConceptoTiposController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionConceptoTipo"})
      }
   """
)
                        
    
}
              

// @LINE:913
// @LINE:912
// @LINE:911
// @LINE:910
// @LINE:909
// @LINE:908
// @LINE:907
// @LINE:906
// @LINE:905
class ReverseCentrosCostosController {
    

// @LINE:906
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/crear"})
      }
   """
)
                        

// @LINE:912
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:913
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:909
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:907
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/guardar"})
      }
   """
)
                        

// @LINE:910
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/actualizar"})
      }
   """
)
                        

// @LINE:911
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/modalBuscar"})
      }
   """
)
                        

// @LINE:908
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:905
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.CentrosCostosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/centroCosto"})
      }
   """
)
                        
    
}
              

// @LINE:1048
// @LINE:1047
// @LINE:778
// @LINE:766
// @LINE:765
// @LINE:764
// @LINE:763
// @LINE:762
// @LINE:761
// @LINE:760
// @LINE:759
// @LINE:758
// @LINE:757
// @LINE:756
class ReversePuestosLaboralesController {
    

// @LINE:766
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.cambiarEstado",
   """
      function(idPuesto,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPuesto", idPuesto), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:1048
def suggestPuestoLaboralTodos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.suggestPuestoLaboralTodos",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestPuestoLaboralTodos/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:757
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/crear"})
      }
   """
)
                        

// @LINE:764
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:763
def modalBuscarTodos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.modalBuscarTodos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/modal-buscar-todos"})
      }
   """
)
                        

// @LINE:765
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:760
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborale/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:758
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/guardar"})
      }
   """
)
                        

// @LINE:761
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/actualizar"})
      }
   """
)
                        

// @LINE:1047
def suggestPuestoLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.suggestPuestoLaboral",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestPuestoLaboral/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:762
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/modal-buscar"})
      }
   """
)
                        

// @LINE:778
def liquidarCierre : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.liquidarCierre",
   """
      function(idPuestoLaboral,idLiquidacionMes) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/liquidarCierre" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPuestoLaboral", idPuestoLaboral), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idLiquidacionMes", idLiquidacionMes)])})
      }
   """
)
                        

// @LINE:759
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:756
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales"})
      }
   """
)
                        
    
}
              

// @LINE:875
// @LINE:874
// @LINE:871
// @LINE:869
// @LINE:868
// @LINE:867
class ReverseLiquidacionPuestosReportesController {
    

// @LINE:875
def enviarReciboPorMail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosReportesController.enviarReciboPorMail",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/reportes/enviarReciboPorMail"})
      }
   """
)
                        

// @LINE:868
def reciboSueldo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosReportesController.reciboSueldo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/reportes/reciboSueldo"})
      }
   """
)
                        

// @LINE:874
def modalReciboSueldoPorPuestoMail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosReportesController.modalReciboSueldoPorPuestoMail",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/reportes/modalReciboSueldoPorPuestoMail" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:867
def reciboSueldoPorPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/reportes/reciboSueldoPorPuesto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:871
def libroSueldos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosReportesController.libroSueldos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/reportes/libroSueldos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:869
def reciboSueldosByLiquidacionMes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionPuestosReportesController.reciboSueldosByLiquidacionMes",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionPuesto/reportes/reciboSueldosByLiquidacionMes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:924
// @LINE:923
// @LINE:922
// @LINE:921
// @LINE:920
// @LINE:919
// @LINE:918
// @LINE:917
// @LINE:916
// @LINE:915
class ReverseEscalasLaboralesController {
    

// @LINE:916
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/crear"})
      }
   """
)
                        

// @LINE:922
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:923
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:919
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:917
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/guardar"})
      }
   """
)
                        

// @LINE:920
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/actualizar"})
      }
   """
)
                        

// @LINE:924
def suggestEscalaLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.suggestEscalaLaboral",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/suggestEscalaLaboral/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:921
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/modalBuscar"})
      }
   """
)
                        

// @LINE:918
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:915
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.EscalasLaboralesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/escalaLaboral"})
      }
   """
)
                        
    
}
              

// @LINE:1010
// @LINE:1009
// @LINE:1008
class ReverseGananciasAccionesController {
    

// @LINE:1010
def modalFormularioF649 : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.GananciasAccionesController.modalFormularioF649",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/gananciasAcciones/modalFormularioF649"})
      }
   """
)
                        

// @LINE:1008
def buscarDatosGananciasEnArchivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.GananciasAccionesController.buscarDatosGananciasEnArchivos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/gananciasAcciones/buscarDatosGananciasEnArchivos"})
      }
   """
)
                        

// @LINE:1009
def modalBuscarDatosGananciasEnArchivos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.GananciasAccionesController.modalBuscarDatosGananciasEnArchivos",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/gananciasAcciones/modalBuscarDatosGananciasEnArchivos"})
      }
   """
)
                        
    
}
              

// @LINE:742
class ReverseIndexController {
    

// @LINE:742
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes"})
      }
   """
)
                        
    
}
              

// @LINE:784
// @LINE:783
// @LINE:781
// @LINE:780
// @LINE:777
// @LINE:776
// @LINE:775
// @LINE:774
// @LINE:773
// @LINE:772
// @LINE:771
// @LINE:770
class ReversePuestosLaboralesAccionesController {
    

// @LINE:783
def modalPreliquidarFinalPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarFinalPuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/acciones/modalPreliquidarPuestoFinal"})
      }
   """
)
                        

// @LINE:773
def crearNovedadesBasicas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.crearNovedadesBasicas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/crearNovedades"})
      }
   """
)
                        

// @LINE:771
def desactivar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.desactivar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/acciones/desactivar"})
      }
   """
)
                        

// @LINE:777
def pasarAControlado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.pasarAControlado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/pasarAControlado"})
      }
   """
)
                        

// @LINE:775
def pasarABorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.pasarABorrador",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/pasarABorrador"})
      }
   """
)
                        

// @LINE:780
def modalPreliquidarPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarPuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/acciones/modalPreliquidarPuesto"})
      }
   """
)
                        

// @LINE:772
def modalCrearNovedades : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.modalCrearNovedades",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/acciones/modalCrearNovedades"})
      }
   """
)
                        

// @LINE:774
def modalPasarABorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.modalPasarABorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/modalPasarABorrador"})
      }
   """
)
                        

// @LINE:776
def modalPasarAControlado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.modalPasarAControlado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/modalPasarAControlado"})
      }
   """
)
                        

// @LINE:770
def activar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.activar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/acciones/activar"})
      }
   """
)
                        

// @LINE:781
def preliquidarPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.preliquidarPuesto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/preliquidarPuesto"})
      }
   """
)
                        

// @LINE:784
def preliquidarFinalPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.PuestosLaboralesAccionesController.preliquidarFinalPuesto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/puestos-laborales/preliquidarPuestoFinal"})
      }
   """
)
                        
    
}
              

// @LINE:998
// @LINE:988
// @LINE:987
// @LINE:986
// @LINE:985
// @LINE:983
// @LINE:982
// @LINE:981
// @LINE:980
// @LINE:979
// @LINE:978
// @LINE:977
// @LINE:976
// @LINE:975
// @LINE:974
// @LINE:973
// @LINE:972
// @LINE:971
// @LINE:970
// @LINE:969
// @LINE:968
class ReverseLiquidacionMesesReportesController {
    

// @LINE:968
def totalPorConceptos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.totalPorConceptos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/totalPorConceptos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:978
def listadoDePuestoLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboral",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoDePuestoLaboral" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:973
def listadoObraSocial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoObraSocial",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoObraSocial" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:980
def listadoDePuestoLaboralComparativoPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboralComparativoPeriodo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoDePuestoLaboralComparativoPeriodo" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:972
def listadoJubilacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoJubilacion",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoJubilacion" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:974
def datosGenerales : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.datosGenerales",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/datosGenerales" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:988
def reportesControlDatosAfipGanancias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.reportesControlDatosAfipGanancias",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/reportesControlDatosAfipGanancias"})
      }
   """
)
                        

// @LINE:987
def modalControlDatosAfipGanancias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.modalControlDatosAfipGanancias",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/modalControlDatosAfipGanancias"})
      }
   """
)
                        

// @LINE:975
def ordenDePago : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.ordenDePago",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/ordenDePago" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:977
def listadoPorConceptosPorPuestoLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoPorConceptosPorPuestoLaboral",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoPorConceptosPorPuestoLaboral" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:971
def listadoSeguroSepelio : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoSeguroSepelio",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoSeguroSepelio" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:969
def comparativoCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.comparativoCertificacion",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/comparativoCertificacion" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:998
def exportDatosPorConcepto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.exportDatosPorConcepto",
   """
      function(liquidacionId,conceptoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionAcciones/exportDatosPorConcepto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("liquidacionId", liquidacionId), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("conceptoId", conceptoId)])})
      }
   """
)
                        

// @LINE:982
def modalDatosAfip : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.modalDatosAfip",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/modalDatosAfip"})
      }
   """
)
                        

// @LINE:983
def reportesDatosAfip : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfip",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/reportesDatosAfip"})
      }
   """
)
                        

// @LINE:986
def reportesDatosAfipGanancias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfipGanancias",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/reportesDatosAfipGanancias"})
      }
   """
)
                        

// @LINE:979
def listadoGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoGeneral",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoGeneral" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:981
def listadoPorEscalaPorPuestoLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoPorEscalaPorPuestoLaboral",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoPorEscalaPorPuestoLaboral" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:985
def modalDatosAfipGanancias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.modalDatosAfipGanancias",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/modalDatosAfipGanancias"})
      }
   """
)
                        

// @LINE:976
def controlDescuentosBasicos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.controlDescuentosBasicos",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/controlDescuentosBasicos" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:970
def listadoSeguroVida : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionMesesReportesController.listadoSeguroVida",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacionMes/reportes/listadoSeguroVida" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:893
// @LINE:892
// @LINE:891
// @LINE:890
// @LINE:889
// @LINE:888
class ReverseLiquidacionDetallesController {
    

// @LINE:888
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionDetallesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacion-detalle/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:893
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionDetallesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacion-detalle/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:891
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionDetallesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacion-detalle/guardar"})
      }
   """
)
                        

// @LINE:892
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionDetallesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacion-detalle/actualizar"})
      }
   """
)
                        

// @LINE:890
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionDetallesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacion-d20301766700etalle/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:889
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.haberes.LiquidacionDetallesController.crear",
   """
      function(liquidacionPuestoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "haberes/liquidacion-detalle/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("liquidacionPuestoId", liquidacionPuestoId)])})
      }
   """
)
                        
    
}
              
}
        

// @LINE:734
// @LINE:733
package controllers.rendiciones.javascript {

// @LINE:733
class ReverseIndexController {
    

// @LINE:733
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rendiciones.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rendiciones"})
      }
   """
)
                        
    
}
              

// @LINE:734
class ReverseRendicionesController {
    

// @LINE:734
def indexPagosRealizados : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rendiciones.RendicionesController.indexPagosRealizados",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rendiciones/pagos-realizados"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:1051
// @LINE:1044
// @LINE:1041
// @LINE:1040
// @LINE:1039
// @LINE:1037
// @LINE:1035
// @LINE:1034
// @LINE:1023
// @LINE:1021
// @LINE:1020
// @LINE:1019
// @LINE:425
// @LINE:424
// @LINE:423
// @LINE:421
// @LINE:420
// @LINE:419
// @LINE:418
// @LINE:417
// @LINE:416
// @LINE:414
// @LINE:413
// @LINE:412
// @LINE:411
// @LINE:410
// @LINE:409
// @LINE:407
// @LINE:406
// @LINE:405
// @LINE:404
// @LINE:403
// @LINE:402
// @LINE:401
// @LINE:400
// @LINE:388
// @LINE:387
// @LINE:386
// @LINE:385
// @LINE:384
// @LINE:383
// @LINE:382
// @LINE:381
// @LINE:380
// @LINE:379
// @LINE:378
// @LINE:376
// @LINE:374
// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
// @LINE:367
// @LINE:366
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:362
// @LINE:361
// @LINE:360
// @LINE:359
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:354
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:349
// @LINE:348
// @LINE:347
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:337
// @LINE:336
// @LINE:334
// @LINE:333
// @LINE:332
// @LINE:331
// @LINE:330
// @LINE:329
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:315
// @LINE:314
// @LINE:313
// @LINE:312
// @LINE:311
// @LINE:309
// @LINE:308
// @LINE:307
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:296
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:287
// @LINE:286
// @LINE:285
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:278
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
// @LINE:268
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:260
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:253
// @LINE:252
// @LINE:250
// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:245
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:240
// @LINE:239
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
// @LINE:231
// @LINE:228
// @LINE:227
// @LINE:226
// @LINE:225
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:216
// @LINE:215
// @LINE:213
// @LINE:211
// @LINE:210
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:203
// @LINE:202
// @LINE:201
// @LINE:200
// @LINE:199
// @LINE:198
// @LINE:196
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
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
// @LINE:162
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
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:104
// @LINE:103
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:92
// @LINE:91
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
package controllers.compras.javascript {

// @LINE:374
// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
class ReverseCertificacionesComprasLineasController {
    

// @LINE:369
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:374
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:372
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra-linea/guardar"})
      }
   """
)
                        

// @LINE:373
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra-linea/actualizar"})
      }
   """
)
                        

// @LINE:371
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:370
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineasController.crear",
   """
      function(certificacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("certificacionId", certificacionId)])})
      }
   """
)
                        
    
}
              

// @LINE:223
// @LINE:222
// @LINE:219
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
class ReverseOrdenesReportesController {
    

// @LINE:108
def exportacionDatosConLineas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.exportacionDatosConLineas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/exportacionDatosConLineas"})
      }
   """
)
                        

// @LINE:107
def exportacionDatos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.exportacionDatos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/exportacionDatos"})
      }
   """
)
                        

// @LINE:106
def cuadroComparativoPrecios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.cuadroComparativoPrecios",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/cuadroComparativoPrecios"})
      }
   """
)
                        

// @LINE:222
def listadoLineas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.listadoLineas",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "orden/reporte/listadoLineas" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:111
def reporteCertificacionPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.reporteCertificacionPaciente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/reporteCertificacionPaciente" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:109
def cuadroSugerenciaAdjudicación : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.cuadroSugerenciaAdjudicación",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/cuadroSugerenciaAdjudicacion"})
      }
   """
)
                        

// @LINE:110
def controlDolar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.controlDolar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/controlDolar"})
      }
   """
)
                        

// @LINE:223
def reporteImputacionDefinitiva : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.reporteImputacionDefinitiva",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/reporte/imputacionDefinitiva" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:219
def reporteImputacionDefinitivaGlobal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.reporteImputacionDefinitivaGlobal",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/reporte/imputacionDefinitiva"})
      }
   """
)
                        

// @LINE:112
def controlProfe : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesReportesController.controlProfe",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ordenCompra/reporte/controlProfe" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:250
// @LINE:249
// @LINE:231
// @LINE:228
// @LINE:227
// @LINE:226
// @LINE:225
// @LINE:221
// @LINE:220
// @LINE:218
class ReverseSolicitudesReportesController {
    

// @LINE:218
def reporteImputacionPreventivaLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.reporteImputacionPreventivaLista",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/imputacionPreventiva"})
      }
   """
)
                        

// @LINE:249
def reportePedidoAbastecimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.reportePedidoAbastecimiento",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/reporte/reportePedidoAbastecimiento" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:228
def informeFarmaciaPorUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.informeFarmaciaPorUsuario",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/informeFarmaciaPorUsuario"})
      }
   """
)
                        

// @LINE:221
def reporteLineasCotizacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.reporteLineasCotizacion",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/lineasCotizacion" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:231
def informeFarmaciaPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.informeFarmaciaPaciente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/informeFarmaciaPaciente"})
      }
   """
)
                        

// @LINE:220
def reporteCuadroSolicitud : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.reporteCuadroSolicitud",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/cuadroSolicitud"})
      }
   """
)
                        

// @LINE:226
def informeFarmacia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.informeFarmacia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/informeFarmacia"})
      }
   """
)
                        

// @LINE:250
def reporteImputacionPreventiva : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.reporteImputacionPreventiva",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/reporte/imputacionPreventiva" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:227
def modalInformeFarmaciaPorUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.modalInformeFarmaciaPorUsuario",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/modalInformeFarmaciaPorUsuario"})
      }
   """
)
                        

// @LINE:225
def modalInformeFarmacia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesReportesController.modalInformeFarmacia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/reporte/modalInformeFarmacia"})
      }
   """
)
                        
    
}
              

// @LINE:216
// @LINE:215
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
class ReverseCertificacionesController {
    

// @LINE:172
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.cambiarEstado",
   """
      function(idCertificacion,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCertificacion", idCertificacion), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:165
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/crear"})
      }
   """
)
                        

// @LINE:171
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:216
def procesarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.procesarMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificaciones/acciones/procesar-masivo"})
      }
   """
)
                        

// @LINE:169
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:168
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:166
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/guardar"})
      }
   """
)
                        

// @LINE:173
def modalEditarCuentaAnalica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.modalEditarCuentaAnalica",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalEditarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:174
def editarCuentaAnalitica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.editarCuentaAnalitica",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/editarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:215
def crearMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.crearMasivo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificaciones/acciones/crear-masivo"})
      }
   """
)
                        

// @LINE:167
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:164
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion"})
      }
   """
)
                        

// @LINE:170
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
class ReverseOrdenesLineasAjustesController {
    

// @LINE:114
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesLineasAjustesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/linea-orden-ajuste/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:116
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesLineasAjustesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/linea-orden-ajuste/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:117
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesLineasAjustesController.crear",
   """
      function(ordenId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/linea-orden-ajuste/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ordenId", ordenId)])})
      }
   """
)
                        

// @LINE:115
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesLineasAjustesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/linea-orden-ajuste/guardar"})
      }
   """
)
                        
    
}
              

// @LINE:1037
// @LINE:266
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:260
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:253
// @LINE:252
class ReverseProveedoresController {
    

// @LINE:261
def guardarContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.guardarContacto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/guardarContacto"})
      }
   """
)
                        

// @LINE:253
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/crear"})
      }
   """
)
                        

// @LINE:264
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:257
def eliminarContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.eliminarContacto",
   """
      function(sid,cId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/eliminarContacto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("sid", sid), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cId", cId)])})
      }
   """
)
                        

// @LINE:266
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:256
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:255
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/guardar"})
      }
   """
)
                        

// @LINE:1037
def suggestProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.suggestProveedor",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestProveedor/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:262
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/actualizar"})
      }
   """
)
                        

// @LINE:260
def actualizarContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.actualizarContacto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/actualizarContacto"})
      }
   """
)
                        

// @LINE:263
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/modalBuscar"})
      }
   """
)
                        

// @LINE:259
def formularioContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.formularioContacto",
   """
      function(proveedorId,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/editarContacto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("proveedorId", proveedorId), (id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:258
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:252
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores"})
      }
   """
)
                        
    
}
              

// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:354
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:349
// @LINE:348
// @LINE:347
class ReverseCertificacionesComprasController {
    

// @LINE:355
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.cambiarEstado",
   """
      function(idCertificacion,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCertificacion", idCertificacion), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:348
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/crear"})
      }
   """
)
                        

// @LINE:354
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:352
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:351
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:349
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/guardar"})
      }
   """
)
                        

// @LINE:356
def modalEditarCuentaAnalica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.modalEditarCuentaAnalica",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/modalEditarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:357
def editarCuentaAnalitica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.editarCuentaAnalitica",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/editarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:350
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:347
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra"})
      }
   """
)
                        

// @LINE:353
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
class ReverseLineasSolicitudesController {
    

// @LINE:121
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.editar",
   """
      function(id,idDeposito) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (idDeposito == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idDeposito", idDeposito))])})
      }
   """
)
                        

// @LINE:120
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.crear",
   """
      function(solicitudId,idDeposito) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("solicitudId", solicitudId), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idDeposito", idDeposito)])})
      }
   """
)
                        

// @LINE:119
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.index",
   """
      function(id,editable,btnEliminar) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable)), (btnEliminar == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("btnEliminar", btnEliminar))])})
      }
   """
)
                        

// @LINE:124
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:122
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/guardar"})
      }
   """
)
                        

// @LINE:123
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/actualizar"})
      }
   """
)
                        

// @LINE:125
def eliminarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasSolicitudesController.eliminarMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-solicitud/eliminarMasivo"})
      }
   """
)
                        
    
}
              

// @LINE:1021
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:315
// @LINE:314
// @LINE:313
// @LINE:312
// @LINE:311
class ReverseTipoProductosController {
    

// @LINE:315
def eliminarTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.eliminarTipoProducto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:316
def actualizarTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.actualizarTipoProducto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/actualizar"})
      }
   """
)
                        

// @LINE:314
def editarTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.editarTipoProducto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:313
def guardarTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.guardarTipoProducto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/guardar"})
      }
   """
)
                        

// @LINE:318
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:312
def crearTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.crearTipoProducto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/crear"})
      }
   """
)
                        

// @LINE:317
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto/modalBuscar"})
      }
   """
)
                        

// @LINE:311
def indexTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.indexTipoProducto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/tipo-producto"})
      }
   """
)
                        

// @LINE:1021
def suggestTipoProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.TipoProductosController.suggestTipoProducto",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestTipoProducto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        
    
}
              

// @LINE:248
// @LINE:247
// @LINE:162
// @LINE:161
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
// @LINE:141
// @LINE:140
class ReverseOrdenesAccionesController {
    

// @LINE:156
def modalEditarRubro : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalEditarRubro",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalEditarRubro" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:151
def editarMontoAdelanto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.editarMontoAdelanto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/editarMontoAdelanto"})
      }
   """
)
                        

// @LINE:248
def generarOrdenSegunCuadroSugerenia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.generarOrdenSegunCuadroSugerenia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/acciones/generarOrdenSegunCuadroSugerenia"})
      }
   """
)
                        

// @LINE:141
def importarListaProductos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.importarListaProductos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/importarListaProductos"})
      }
   """
)
                        

// @LINE:155
def editarFechaProvision : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.editarFechaProvision",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/editarFechaProvision"})
      }
   """
)
                        

// @LINE:158
def modalOrdenMail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalOrdenMail",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalOrdenMail" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:247
def combinar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.combinar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/acciones/combinar"})
      }
   """
)
                        

// @LINE:150
def modalEditarMontoAdelanto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalEditarMontoAdelanto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalEditarMontoAdelanto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:157
def editarRubro : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.editarRubro",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/editarRubro"})
      }
   """
)
                        

// @LINE:161
def modalCrearDispo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalCrearDispo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalCrearDispo" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:140
def modalImportarListaProductos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalImportarListaProductos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalImportarListaProductos"})
      }
   """
)
                        

// @LINE:162
def crearDispo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.crearDispo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/crearDispo"})
      }
   """
)
                        

// @LINE:152
def modalEditarCotDolar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalEditarCotDolar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalEditarCotDolar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:154
def modalEditarFechaProvision : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.modalEditarFechaProvision",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalEditarFechaProvision" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:159
def enviarOrdenMail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.enviarOrdenMail",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/enviarOrdenMail"})
      }
   """
)
                        

// @LINE:153
def editarCotDolar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesAccionesController.editarCotDolar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/editarCotDolar"})
      }
   """
)
                        
    
}
              

// @LINE:1019
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
class ReverseArticulosController {
    

// @LINE:1019
def suggestArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.suggestArticulo",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestArticulo/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:323
def editarArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.editarArticulo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:320
def indexArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.indexArticulo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo"})
      }
   """
)
                        

// @LINE:327
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:324
def eliminarArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.eliminarArticulo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:322
def guardarArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.guardarArticulo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/guardar"})
      }
   """
)
                        

// @LINE:326
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/modalBuscar"})
      }
   """
)
                        

// @LINE:325
def actualizarArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.actualizarArticulo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/actualizar"})
      }
   """
)
                        

// @LINE:321
def crearArticulo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ArticulosController.crearArticulo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/articulo/crear"})
      }
   """
)
                        
    
}
              

// @LINE:211
// @LINE:210
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:205
class ReverseCertificacionesComprasLineaAjustesController {
    

// @LINE:205
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineaAjustesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea-ajuste/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:211
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineaAjustesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea-ajuste/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:208
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineaAjustesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea-ajuste/guardar"})
      }
   """
)
                        

// @LINE:210
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineaAjustesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea-ajuste/actualizar"})
      }
   """
)
                        

// @LINE:207
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineaAjustesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea-ajuste/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:206
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasLineaAjustesController.crear",
   """
      function(certificacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea-ajuste/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("certificacionId", certificacionId)])})
      }
   """
)
                        
    
}
              

// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
class ReverseAjustesSolicitudesController {
    

// @LINE:128
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.AjustesSolicitudesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ajuste-solicitud/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:131
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.AjustesSolicitudesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ajuste-solicitud/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:129
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.AjustesSolicitudesController.crear",
   """
      function(solicitudId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ajuste-solicitud/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("solicitudId", solicitudId)])})
      }
   """
)
                        

// @LINE:130
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.AjustesSolicitudesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ajuste-solicitud/guardar"})
      }
   """
)
                        
    
}
              

// @LINE:334
// @LINE:333
// @LINE:332
// @LINE:331
// @LINE:330
// @LINE:329
class ReverseProveedorAtributosController {
    

// @LINE:329
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorAtributosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-atributo/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:334
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorAtributosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-atributo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:332
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorAtributosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-atributo/guardar"})
      }
   """
)
                        

// @LINE:333
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorAtributosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-atributo/actualizar"})
      }
   """
)
                        

// @LINE:331
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorAtributosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-atributo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:330
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorAtributosController.crear",
   """
      function(proveedorId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-atributo/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("proveedorId", proveedorId)])})
      }
   """
)
                        
    
}
              

// @LINE:203
// @LINE:202
// @LINE:201
// @LINE:200
// @LINE:199
// @LINE:198
class ReverseLineasCertificacionesController {
    

// @LINE:198
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasCertificacionesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:203
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasCertificacionesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:201
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasCertificacionesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea/guardar"})
      }
   """
)
                        

// @LINE:202
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasCertificacionesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea/actualizar"})
      }
   """
)
                        

// @LINE:200
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasCertificacionesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:199
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasCertificacionesController.crear",
   """
      function(certificacionId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("certificacionId", certificacionId)])})
      }
   """
)
                        
    
}
              

// @LINE:160
class ReverseOrdenSubrubroController {
    

// @LINE:160
def listOptions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenSubrubroController.listOptions",
   """
      function(rubroId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ordenSubrubro/listOptions" + _qS([(rubroId == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("rubroId", rubroId))])})
      }
   """
)
                        
    
}
              

// @LINE:414
// @LINE:413
// @LINE:412
// @LINE:411
// @LINE:410
// @LINE:409
// @LINE:407
// @LINE:406
// @LINE:405
// @LINE:404
// @LINE:403
// @LINE:402
// @LINE:401
// @LINE:400
class ReverseCajaChicaController {
    

// @LINE:407
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.cambiarEstado",
   """
      function(id,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:410
def reporteImputacionPreventivaLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.reporteImputacionPreventivaLista",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/reporteImputacionPreventivaLista" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:402
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/crear"})
      }
   """
)
                        

// @LINE:405
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.actualizar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:409
def resumenPresupuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.resumenPresupuesto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/resumenPresupuesto" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:401
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:411
def reporteImputacionPreventivaAjustesLista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.reporteImputacionPreventivaAjustesLista",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/reporteImputacionPreventivaListaAjuste" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:406
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:403
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.guardar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/guardar"})
      }
   """
)
                        

// @LINE:413
def reporteCajaChica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.reporteCajaChica",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/reporteCajaChica" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:404
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:400
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica"})
      }
   """
)
                        

// @LINE:412
def reporteImputacionDefinitiva : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.reporteImputacionDefinitiva",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/reporteImputacionDefinitiva" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:414
def reporteCajaChicaOrdenCargo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaController.reporteCajaChicaOrdenCargo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica/reporteCajaChicaOrdenCargo" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:1039
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:278
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
class ReverseClientesController {
    

// @LINE:271
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/crear"})
      }
   """
)
                        

// @LINE:281
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:278
def eliminarContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.eliminarContacto",
   """
      function(sid,cId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/eliminarContacto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("sid", sid), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cId", cId)])})
      }
   """
)
                        

// @LINE:276
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:275
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:272
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/guardar"})
      }
   """
)
                        

// @LINE:274
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/actualizar"})
      }
   """
)
                        

// @LINE:280
def actualizarContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.actualizarContacto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/actualizarContacto"})
      }
   """
)
                        

// @LINE:279
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/modalBuscar"})
      }
   """
)
                        

// @LINE:282
def modalCarga : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.modalCarga",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/modalCargar"})
      }
   """
)
                        

// @LINE:277
def formularioContacto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.formularioContacto",
   """
      function(clienteId,id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/editarContacto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("clienteId", clienteId), (id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:1039
def suggestCliente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.suggestCliente",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestCliente/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:283
def guardarDesdeModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.guardarDesdeModal",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/guardarDesdeModal"})
      }
   """
)
                        

// @LINE:273
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:270
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ClientesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/clientes"})
      }
   """
)
                        
    
}
              

// @LINE:239
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
class ReversePedidosFondosController {
    

// @LINE:234
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo/crear"})
      }
   """
)
                        

// @LINE:239
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.actualizar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:238
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:237
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:235
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo/guardar"})
      }
   """
)
                        

// @LINE:236
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:233
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.PedidosFondosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedidoFondo"})
      }
   """
)
                        
    
}
              

// @LINE:196
// @LINE:195
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
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
class ReverseCertificacionesAccionesController {
    

// @LINE:178
def pasarCertificadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.pasarCertificadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/pasarCertificadoMasivo"})
      }
   """
)
                        

// @LINE:190
def modalDuplicarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalDuplicarMasivo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalDuplicarMasivo"})
      }
   """
)
                        

// @LINE:195
def modalDetalleCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalDetalleCertificacion",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalDetalleCertificacion" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:181
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:193
def crearAguinaldo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.crearAguinaldo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/CrearAguinaldo"})
      }
   """
)
                        

// @LINE:191
def duplicarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.duplicarMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/duplicarMasivo"})
      }
   """
)
                        

// @LINE:179
def modalPasarAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalPasarAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalPasarAprobado"})
      }
   """
)
                        

// @LINE:192
def modalCrearAguinaldo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalCrearAguinaldo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalCrearAguinaldo"})
      }
   """
)
                        

// @LINE:184
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:182
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:185
def modalEditarFechaCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalEditarFechaCertificacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalEditarFechaCertificacion"})
      }
   """
)
                        

// @LINE:183
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:180
def pasarAprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.pasarAprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/pasarAprobadoMasivo"})
      }
   """
)
                        

// @LINE:186
def editarFechaCertificacionMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.editarFechaCertificacionMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/editarFechaCertificacionMasivo"})
      }
   """
)
                        

// @LINE:196
def modalDetalleCertificacionesPorEstadoPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalDetalleCertificacionesPorEstadoPorPeriodo",
   """
      function(nombrePeriodo,estado,proveedorId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("nombrePeriodo", nombrePeriodo), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("estado", estado), (""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("proveedorId", proveedorId)])})
      }
   """
)
                        

// @LINE:175
def modalPasarEnCurso : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalPasarEnCurso",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalPasarEnCurso"})
      }
   """
)
                        

// @LINE:177
def modalPasarCertificado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.modalPasarCertificado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/modalPasarCertificado"})
      }
   """
)
                        

// @LINE:176
def pasarEnCursoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesAccionesController.pasarEnCursoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/pasarEnCursoMasivo"})
      }
   """
)
                        
    
}
              

// @LINE:104
// @LINE:103
class ReverseOrdenesLineasClientesController {
    

// @LINE:103
def guardarAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesLineasClientesController.guardarAjax",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden-cliente/guardarAjax"})
      }
   """
)
                        

// @LINE:104
def eliminarAjax : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesLineasClientesController.eliminarAjax",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden-cliente/eliminarAjax" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:1051
// @LINE:344
// @LINE:343
class ReverseObrasSocialesController {
    

// @LINE:343
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ObrasSocialesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ob/modalBuscar"})
      }
   """
)
                        

// @LINE:1051
def suggestObrasocial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ObrasSocialesController.suggestObrasocial",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestOb/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:344
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ObrasSocialesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/ob/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:425
// @LINE:424
// @LINE:423
class ReverseCajaChicaPresupuestoLineasController {
    

// @LINE:424
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaPresupuestoLineasController.crear",
   """
      function(cajaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-presupuesto/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("cajaId", cajaId)])})
      }
   """
)
                        

// @LINE:423
def lista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaPresupuestoLineasController.lista",
   """
      function(cajaId,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-presupuesto" + _qS([(cajaId == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cajaId", cajaId)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:425
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaPresupuestoLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-presupuesto/guardar"})
      }
   """
)
                        
    
}
              

// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:337
// @LINE:336
class ReverseProveedorDatosDgrController {
    

// @LINE:337
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorDatosDgrController.crear",
   """
      function(cuit) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-datodgr/crear" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cuit", cuit)])})
      }
   """
)
                        

// @LINE:336
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorDatosDgrController.index",
   """
      function(cuit,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-datodgr/index" + _qS([(cuit == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cuit", cuit)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:341
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorDatosDgrController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-datodgr/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:339
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorDatosDgrController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-datodgr/guardar"})
      }
   """
)
                        

// @LINE:340
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorDatosDgrController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-datodgr/actualizar"})
      }
   """
)
                        

// @LINE:338
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedorDatosDgrController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-proveedor-datodgr/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
class ReverseLineasOrdenesController {
    

// @LINE:94
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:99
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:97
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/guardar"})
      }
   """
)
                        

// @LINE:98
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/actualizar"})
      }
   """
)
                        

// @LINE:101
def eliminarMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.eliminarMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/eliminar-masivo"})
      }
   """
)
                        

// @LINE:96
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:95
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.crear",
   """
      function(ordenId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("ordenId", ordenId)])})
      }
   """
)
                        

// @LINE:100
def modalAddClientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasOrdenesController.modalAddClientes",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/linea-orden/modalAddClientes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:421
// @LINE:420
// @LINE:419
// @LINE:418
// @LINE:417
// @LINE:416
class ReverseCajaChicaMovimientosController {
    

// @LINE:421
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaMovimientosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-movimientos/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:419
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaMovimientosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-movimientos/guardar"})
      }
   """
)
                        

// @LINE:420
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaMovimientosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-movimientos/actualizar"})
      }
   """
)
                        

// @LINE:416
def lista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaMovimientosController.lista",
   """
      function(cajaId,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-movimientos" + _qS([(cajaId == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("cajaId", cajaId)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:418
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaMovimientosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-movimientos/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:417
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CajaChicaMovimientosController.crear",
   """
      function(cajaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/caja-chica-movimientos/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("cajaId", cajaId)])})
      }
   """
)
                        
    
}
              

// @LINE:388
// @LINE:387
// @LINE:386
// @LINE:385
// @LINE:384
// @LINE:383
// @LINE:382
// @LINE:381
// @LINE:380
// @LINE:379
// @LINE:378
class ReverseCertificacionesObrasController {
    

// @LINE:386
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.cambiarEstado",
   """
      function(idCertificacion,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idCertificacion", idCertificacion), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:379
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/crear"})
      }
   """
)
                        

// @LINE:385
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:383
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:382
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:380
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/guardar"})
      }
   """
)
                        

// @LINE:387
def modalEditarCuentaAnalica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.modalEditarCuentaAnalica",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/modalEditarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:388
def editarCuentaAnalitica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.editarCuentaAnalitica",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/editarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:381
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:378
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra"})
      }
   """
)
                        

// @LINE:384
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesObrasController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-obra/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:1020
// @LINE:309
// @LINE:308
// @LINE:307
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
class ReverseCategoriasController {
    

// @LINE:307
def actualizarCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.actualizarCategoria",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/actualizar"})
      }
   """
)
                        

// @LINE:306
def eliminarCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.eliminarCategoria",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:305
def editarCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.editarCategoria",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1020
def suggestCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.suggestCategoria",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestCategoria/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:309
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:308
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/modalBuscar"})
      }
   """
)
                        

// @LINE:302
def indexCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.indexCategoria",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias"})
      }
   """
)
                        

// @LINE:304
def guardarCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.guardarCategoria",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/guardar"})
      }
   """
)
                        

// @LINE:303
def crearCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CategoriasController.crearCategoria",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/categorias/crear"})
      }
   """
)
                        
    
}
              

// @LINE:245
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:240
class ReverseLineasPedidosFondosController {
    

// @LINE:240
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasPedidosFondosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedido-fondo-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:245
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasPedidosFondosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedido-fondo-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:243
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasPedidosFondosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedido-fondo-linea/guardar"})
      }
   """
)
                        

// @LINE:244
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasPedidosFondosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedido-fondo-linea/actualizar"})
      }
   """
)
                        

// @LINE:242
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasPedidosFondosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedido-fondo-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:241
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.LineasPedidosFondosController.crear",
   """
      function(pedidoFondoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/pedido-fondo-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pedidoFondoId", pedidoFondoId)])})
      }
   """
)
                        
    
}
              

// @LINE:65
class ReverseIndexController {
    

// @LINE:65
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras"})
      }
   """
)
                        
    
}
              

// @LINE:1035
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseOrdenesController {
    

// @LINE:146
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.cambiarEstado",
   """
      function(idOrden,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idOrden", idOrden), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:134
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/crear"})
      }
   """
)
                        

// @LINE:139
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1035
def suggestOrden : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.suggestOrden",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestOrden/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:143
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:137
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:135
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/guardar"})
      }
   """
)
                        

// @LINE:148
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:147
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalBuscar"})
      }
   """
)
                        

// @LINE:144
def modalEditarCuentaAnalica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.modalEditarCuentaAnalica",
   """
      function(tipo) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/modalEditarCuentaAnalitica" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("tipo", tipo)])})
      }
   """
)
                        

// @LINE:145
def editarCuentaAnalitica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.editarCuentaAnalitica",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/editarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:136
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:133
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden"})
      }
   """
)
                        

// @LINE:138
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.OrdenesController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/orden/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:92
// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
class ReverseSolicitudAccionesController {
    

// @LINE:86
def modalPasarAprobadoPorPresupuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.modalPasarAprobadoPorPresupuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalPasarAprobadoPorPresupuesto"})
      }
   """
)
                        

// @LINE:92
def asignarUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.asignarUsuario",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/asignarUsuario"})
      }
   """
)
                        

// @LINE:87
def pasarAprobadoPorPresupuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.pasarAprobadoPorPresupuesto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/pasarAprobadoPorPresupuesto"})
      }
   """
)
                        

// @LINE:83
def importarListaProductos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.importarListaProductos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/importarListaProductos"})
      }
   """
)
                        

// @LINE:85
def modificarPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.modificarPaciente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modificarPaciente"})
      }
   """
)
                        

// @LINE:89
def pasarAutorizado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.pasarAutorizado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/pasarAutorizado"})
      }
   """
)
                        

// @LINE:84
def modalModificarPaciente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.modalModificarPaciente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalModificarPacientes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:91
def modalAsignarUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.modalAsignarUsuario",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalAsignarUsuario" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:82
def modalImportarListaProductos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.modalImportarListaProductos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalImportarListaProductos"})
      }
   """
)
                        

// @LINE:88
def modalPasarAutorizado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudAccionesController.modalPasarAutorizado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalPasarAutorizado"})
      }
   """
)
                        
    
}
              

// @LINE:268
// @LINE:265
class ReverseProveedoresAccionesController {
    

// @LINE:268
def actualizarMail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresAccionesController.actualizarMail",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/actualizarMail"})
      }
   """
)
                        

// @LINE:265
def modalInformacionProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProveedoresAccionesController.modalInformacionProveedor",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/proveedores/modalInformacionProveedor" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:376
class ReverseCertificacionesComprasReportesController {
    

// @LINE:376
def reporteCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasReportesController.reporteCertificacion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificaciones-compra/reporteCertificacion"})
      }
   """
)
                        
    
}
              

// @LINE:1034
// @LINE:81
// @LINE:80
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
class ReverseSolicitudesController {
    

// @LINE:75
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.cambiarEstado",
   """
      function(idSolicitud,idEstado,searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idSolicitud", idSolicitud), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:68
def guardarSolicitud : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.guardarSolicitud",
   """
      function(searchIndex) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/guardar" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:70
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.editar",
   """
      function(id,searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:67
def crearSolicitud : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.crearSolicitud",
   """
      function(searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:76
def redirectSearchIndex : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.redirectSearchIndex",
   """
      function(searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/redirectIndex" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:1034
def suggestSolicitud : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.suggestSolicitud",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestSolicitud/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:81
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:72
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.eliminar",
   """
      function(id,searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:78
def modalEditarCuentaAnalica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.modalEditarCuentaAnalica",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalEditarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:80
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modalBuscar"})
      }
   """
)
                        

// @LINE:79
def editarCuentaAnalitica : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.editarCuentaAnalitica",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/editarCuentaAnalitica"})
      }
   """
)
                        

// @LINE:69
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.ver",
   """
      function(id,searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:71
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.duplicar",
   """
      function(id,searchIndex) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        

// @LINE:74
def modificarEntregado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.modificarEntregado",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/modificarEntregado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:66
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud"})
      }
   """
)
                        

// @LINE:73
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.SolicitudesController.actualizar",
   """
      function(id,searchIndex) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/solicitud/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("searchIndex", searchIndex)])})
      }
   """
)
                        
    
}
              

// @LINE:213
// @LINE:194
// @LINE:189
// @LINE:188
// @LINE:187
class ReverseCertificacionesReportesController {
    

// @LINE:189
def bajas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesReportesController.bajas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion/reportes/bajas"})
      }
   """
)
                        

// @LINE:188
def reporteElevaciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesReportesController.reporteElevaciones",
   """
      function(desc) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/reporteElevaciones" + _qS([(""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("desc", desc)])})
      }
   """
)
                        

// @LINE:187
def reporteTasas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesReportesController.reporteTasas",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/reporteTasa"})
      }
   """
)
                        

// @LINE:194
def reportePlanillaSueldos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesReportesController.reportePlanillaSueldos",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/reportePlanilla"})
      }
   """
)
                        

// @LINE:213
def reporteCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesReportesController.reporteCertificacion",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificaciones/reporteCertificacion"})
      }
   """
)
                        
    
}
              

// @LINE:1044
// @LINE:1041
// @LINE:1040
// @LINE:1023
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:296
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:287
// @LINE:286
// @LINE:285
class ReverseProductosController {
    

// @LINE:289
def editarProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.editarProducto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/productos/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:294
def modalBuscarSolicitudes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.modalBuscarSolicitudes",
   """
      function(idSolicitud) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/modalBuscarSolicitudes" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idSolicitud", idSolicitud)])})
      }
   """
)
                        

// @LINE:1023
def suggestUdm : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.suggestUdm",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestUdm/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:295
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:298
def cargaProductoRismi : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.cargaProductoRismi",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/cargaProductoRismi"})
      }
   """
)
                        

// @LINE:291
def actualizarProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.actualizarProducto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/actualizar"})
      }
   """
)
                        

// @LINE:286
def listarProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.listarProducto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/productos/"})
      }
   """
)
                        

// @LINE:1040
def suggestProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.suggestProducto",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestProducto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:296
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:290
def eliminarProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.eliminarProducto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/productos/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:285
def indexProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.indexProducto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/productos"})
      }
   """
)
                        

// @LINE:292
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/modalBuscar"})
      }
   """
)
                        

// @LINE:299
def modalCarga : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.modalCarga",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/modalCargar"})
      }
   """
)
                        

// @LINE:288
def guardarProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.guardarProducto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/productos/guardar"})
      }
   """
)
                        

// @LINE:293
def modalBuscarIps : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.modalBuscarIps",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/modalBuscarIps"})
      }
   """
)
                        

// @LINE:300
def guardarProductoDesdeModal : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.guardarProductoDesdeModal",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/guardarProductoDesdeModal"})
      }
   """
)
                        

// @LINE:1044
def getDataSuggestSolicitud : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.getDataSuggestSolicitud",
   """
      function(input,idDeposito) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestProductoSolicitud/" + (""" + implicitly[PathBindable[Long]].javascriptUnbind + """)("idDeposito", idDeposito) + "/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:297
def getPrecioProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.getPrecioProducto",
   """
      function(producto_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/producto/getPrecio" + _qS([(producto_id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("producto_id", producto_id))])})
      }
   """
)
                        

// @LINE:287
def crearProducto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.crearProducto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/productos/crear"})
      }
   """
)
                        

// @LINE:1041
def suggestProductoPresupuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.ProductosController.suggestProductoPresupuesto",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestProductoPresupuesto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        
    
}
              

// @LINE:367
// @LINE:366
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:362
// @LINE:361
// @LINE:360
// @LINE:359
// @LINE:358
class ReverseCertificacionesComprasAccionesController {
    

// @LINE:361
def pasarCertificadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.pasarCertificadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/pasarCertificadoMasivo"})
      }
   """
)
                        

// @LINE:362
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:365
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:363
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:366
def modalEditarFechaCertificacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.modalEditarFechaCertificacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/modalEditarFechaCertificacion"})
      }
   """
)
                        

// @LINE:364
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:367
def editarFechaCertificacionMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.editarFechaCertificacionMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/editarFechaCertificacionMasivo"})
      }
   """
)
                        

// @LINE:358
def modalPasarEnCurso : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.modalPasarEnCurso",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/modalPasarEnCurso"})
      }
   """
)
                        

// @LINE:360
def modalPasarCertificado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.modalPasarCertificado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/modalPasarCertificado"})
      }
   """
)
                        

// @LINE:359
def pasarEnCursoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.compras.CertificacionesComprasAccionesController.pasarEnCursoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "compras/certificacion-compra/pasarEnCursoMasivo"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:1053
// @LINE:1033
// @LINE:1030
// @LINE:1029
// @LINE:1028
// @LINE:1027
// @LINE:1026
// @LINE:663
// @LINE:662
// @LINE:661
// @LINE:660
// @LINE:659
// @LINE:658
// @LINE:656
// @LINE:655
// @LINE:654
// @LINE:653
// @LINE:652
// @LINE:651
// @LINE:649
// @LINE:648
// @LINE:646
// @LINE:645
// @LINE:643
// @LINE:642
// @LINE:640
// @LINE:638
// @LINE:637
// @LINE:636
// @LINE:635
// @LINE:634
// @LINE:633
// @LINE:632
// @LINE:631
// @LINE:629
// @LINE:628
// @LINE:627
// @LINE:626
// @LINE:625
// @LINE:624
// @LINE:622
// @LINE:621
// @LINE:620
// @LINE:618
// @LINE:617
// @LINE:616
// @LINE:615
// @LINE:613
// @LINE:612
// @LINE:611
// @LINE:610
// @LINE:609
// @LINE:608
// @LINE:607
// @LINE:606
// @LINE:605
// @LINE:602
// @LINE:600
// @LINE:599
// @LINE:598
// @LINE:597
// @LINE:596
// @LINE:595
// @LINE:594
// @LINE:593
// @LINE:592
// @LINE:591
// @LINE:589
// @LINE:588
// @LINE:587
// @LINE:586
// @LINE:585
// @LINE:584
// @LINE:583
// @LINE:582
// @LINE:581
// @LINE:580
// @LINE:579
// @LINE:578
// @LINE:576
// @LINE:575
// @LINE:574
// @LINE:573
// @LINE:572
// @LINE:571
// @LINE:570
// @LINE:569
// @LINE:567
// @LINE:566
// @LINE:565
// @LINE:564
// @LINE:563
// @LINE:562
// @LINE:561
// @LINE:560
// @LINE:559
// @LINE:557
// @LINE:556
// @LINE:554
// @LINE:553
// @LINE:551
// @LINE:550
// @LINE:549
// @LINE:548
// @LINE:547
// @LINE:546
// @LINE:545
// @LINE:544
// @LINE:542
// @LINE:541
// @LINE:540
// @LINE:539
// @LINE:538
// @LINE:537
// @LINE:535
// @LINE:534
// @LINE:533
// @LINE:532
// @LINE:531
// @LINE:530
// @LINE:528
// @LINE:527
// @LINE:526
// @LINE:525
// @LINE:524
// @LINE:523
// @LINE:521
// @LINE:520
// @LINE:519
// @LINE:518
// @LINE:517
// @LINE:516
// @LINE:514
// @LINE:513
// @LINE:512
// @LINE:511
// @LINE:510
// @LINE:509
// @LINE:507
// @LINE:506
// @LINE:505
// @LINE:504
// @LINE:503
// @LINE:502
// @LINE:501
// @LINE:500
// @LINE:499
// @LINE:498
package controllers.rrhh.javascript {

// @LINE:663
// @LINE:662
// @LINE:661
// @LINE:660
// @LINE:659
// @LINE:658
class ReverseAgentesSeguimientoLineasController {
    

// @LINE:658
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/seguimiento-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:663
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/seguimiento-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:661
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/seguimiento-linea/guardar"})
      }
   """
)
                        

// @LINE:662
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoLineasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/seguimiento-linea/actualizar"})
      }
   """
)
                        

// @LINE:660
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoLineasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/seguimiento-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:659
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoLineasController.crear",
   """
      function(seguimientoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/seguimiento-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("seguimientoId", seguimientoId)])})
      }
   """
)
                        
    
}
              

// @LINE:507
// @LINE:506
// @LINE:505
// @LINE:504
// @LINE:503
// @LINE:502
// @LINE:501
class ReverseAgentesEstudiosController {
    

// @LINE:507
def listOptionsEstudioSubareas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.listOptionsEstudioSubareas",
   """
      function(estudioAreaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/listOptionsSubarea" + _qS([(estudioAreaId == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("estudioAreaId", estudioAreaId))])})
      }
   """
)
                        

// @LINE:501
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:506
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:504
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/guardar"})
      }
   """
)
                        

// @LINE:505
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/actualizar"})
      }
   """
)
                        

// @LINE:503
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:502
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesEstudiosController.crear",
   """
      function(agenteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-estudio/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        
    
}
              

// @LINE:528
// @LINE:527
// @LINE:526
// @LINE:525
// @LINE:524
// @LINE:523
class ReverseAgentesHijosController {
    

// @LINE:523
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesHijosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-hijo/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:528
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesHijosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-hijo/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:526
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesHijosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-hijo/guardar"})
      }
   """
)
                        

// @LINE:527
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesHijosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-hijo/actualizar"})
      }
   """
)
                        

// @LINE:525
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesHijosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-hijo/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:524
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesHijosController.crear",
   """
      function(agenteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-hijo/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        
    
}
              

// @LINE:646
// @LINE:645
class ReverseAgentesAsistenciasReportesController {
    

// @LINE:645
def reporteLicencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasReportesController.reporteLicencia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteAsistencia/reporteLicencia"})
      }
   """
)
                        

// @LINE:646
def reporteLicenciaMedicinaLaboral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasReportesController.reporteLicenciaMedicinaLaboral",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteAsistencia/reporteLicenciaMedicinaLaboral"})
      }
   """
)
                        
    
}
              

// @LINE:514
// @LINE:513
// @LINE:512
// @LINE:511
// @LINE:510
// @LINE:509
class ReverseAgentesRulController {
    

// @LINE:509
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesRulController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-rul/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:514
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesRulController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-rul/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:512
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesRulController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-rul/guardar"})
      }
   """
)
                        

// @LINE:513
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesRulController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-rul/actualizar"})
      }
   """
)
                        

// @LINE:511
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesRulController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-rul/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:510
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesRulController.crear",
   """
      function(agenteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-rul/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        
    
}
              

// @LINE:618
// @LINE:617
// @LINE:616
// @LINE:615
class ReverseAgentesReportesController {
    

// @LINE:617
def reportesDatosAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesReportesController.reportesDatosAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/reportes/reportesDatosAgente"})
      }
   """
)
                        

// @LINE:615
def ficha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesReportesController.ficha",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/reportes/ficha" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:616
def fichaAptitud : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesReportesController.fichaAptitud",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/reportes/fichaAptitud" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:618
def reportesCertificacionesAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesReportesController.reportesCertificacionesAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/reportes/reportesCertificacionesAgente"})
      }
   """
)
                        
    
}
              

// @LINE:1029
// @LINE:567
// @LINE:566
// @LINE:565
// @LINE:564
// @LINE:563
// @LINE:562
// @LINE:561
// @LINE:560
// @LINE:559
class ReverseTipoResidenciasController {
    

// @LINE:561
def indexTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.indexTipoResidencia",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia"})
      }
   """
)
                        

// @LINE:563
def guardarTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.guardarTipoResidencia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/guardar"})
      }
   """
)
                        

// @LINE:560
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:566
def actualizarTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.actualizarTipoResidencia",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/actualizar"})
      }
   """
)
                        

// @LINE:562
def crearTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.crearTipoResidencia",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/crear"})
      }
   """
)
                        

// @LINE:567
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:1029
def suggestTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.suggestTipoResidencia",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestTipoResidencia/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:565
def eliminarTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.eliminarTipoResidencia",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:559
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/modalBuscar"})
      }
   """
)
                        

// @LINE:564
def editarTipoResidencia : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.TipoResidenciasController.editarTipoResidencia",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/tipoResidencia/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:613
// @LINE:612
// @LINE:611
// @LINE:610
// @LINE:609
// @LINE:608
// @LINE:607
// @LINE:606
// @LINE:605
class ReverseNovedadesController {
    

// @LINE:608
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/crear"})
      }
   """
)
                        

// @LINE:606
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/ver" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:607
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:609
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/guardar"})
      }
   """
)
                        

// @LINE:611
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/actualizar"})
      }
   """
)
                        

// @LINE:612
def lista : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.lista",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/lista"})
      }
   """
)
                        

// @LINE:613
def getFeriados : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.getFeriados",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/feriados"})
      }
   """
)
                        

// @LINE:610
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:605
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.NovedadesController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/novedades"})
      }
   """
)
                        
    
}
              

// @LINE:1027
// @LINE:551
// @LINE:550
// @LINE:549
// @LINE:548
// @LINE:547
// @LINE:546
// @LINE:545
// @LINE:544
class ReverseEspecialidadesController {
    

// @LINE:1027
def suggestEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.suggestEspecialidad",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestEspecialidad/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:548
def eliminarEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.eliminarEspecialidad",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:549
def actualizarEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.actualizarEspecialidad",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/actualizar"})
      }
   """
)
                        

// @LINE:551
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:547
def editarEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.editarEspecialidad",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:550
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/modalBuscar"})
      }
   """
)
                        

// @LINE:546
def guardarEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.guardarEspecialidad",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/guardar"})
      }
   """
)
                        

// @LINE:545
def crearEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.crearEspecialidad",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad/crear"})
      }
   """
)
                        

// @LINE:544
def indexEspecialidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.EspecialidadesController.indexEspecialidad",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/especialidad"})
      }
   """
)
                        
    
}
              

// @LINE:643
// @LINE:642
// @LINE:640
// @LINE:638
// @LINE:637
// @LINE:636
// @LINE:635
// @LINE:634
// @LINE:633
// @LINE:632
// @LINE:631
// @LINE:629
// @LINE:628
// @LINE:627
// @LINE:626
// @LINE:625
// @LINE:624
class ReverseAgentesAsistenciasLicenciasController {
    

// @LINE:631
def modalPasarBorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarBorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/modalPasarBorrador"})
      }
   """
)
                        

// @LINE:640
def resumen : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.resumen",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/resumen" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:624
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.index",
   """
      function(id,editable,tipoLicencia) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable)), (tipoLicencia == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("tipoLicencia", tipoLicencia))])})
      }
   """
)
                        

// @LINE:636
def pasarPreAprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.pasarPreAprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/pasarPreAprobadoMasivo"})
      }
   """
)
                        

// @LINE:643
def getListaLicenciasEnFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasEnFecha",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/getListaLicenciasEnFecha"})
      }
   """
)
                        

// @LINE:629
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:637
def modalPasarAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/modalPasarAprobado"})
      }
   """
)
                        

// @LINE:627
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencian/guardar"})
      }
   """
)
                        

// @LINE:634
def pasarCanceladoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.pasarCanceladoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/pasarCanceladoMasivo"})
      }
   """
)
                        

// @LINE:628
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/actualizar"})
      }
   """
)
                        

// @LINE:632
def pasarBorradorMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.pasarBorradorMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/pasarBorradorMasivo"})
      }
   """
)
                        

// @LINE:642
def getListaLicenciasPendientes : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/getListaLicenciasPendientes"})
      }
   """
)
                        

// @LINE:633
def modalPasarCancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarCancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/modalPasarCancelado"})
      }
   """
)
                        

// @LINE:638
def pasarAprobadoMasivo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.pasarAprobadoMasivo",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/pasarAprobadoMasivo"})
      }
   """
)
                        

// @LINE:626
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:625
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.crear",
   """
      function(agenteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        

// @LINE:635
def modalPasarPreAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarPreAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-asistencia-licencia/modalPasarPreAprobado"})
      }
   """
)
                        
    
}
              

// @LINE:1053
// @LINE:557
// @LINE:556
class ReverseCiesController {
    

// @LINE:1053
def suggestCie : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.CiesController.suggestCie",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestCie/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:556
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.CiesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/cie/modalBuscar"})
      }
   """
)
                        

// @LINE:557
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.CiesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/cie/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:1033
// @LINE:602
// @LINE:589
// @LINE:586
// @LINE:585
// @LINE:584
// @LINE:583
// @LINE:582
// @LINE:581
// @LINE:580
// @LINE:579
// @LINE:578
class ReverseAgentesController {
    

// @LINE:582
def eliminarAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.eliminarAgente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:589
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.cambiarEstado",
   """
      function(idAgente,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/cambiar-estado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idAgente", idAgente), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:602
def actualizarMail : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.actualizarMail",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/actualizarMail"})
      }
   """
)
                        

// @LINE:580
def guardarAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.guardarAgente",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/guardar"})
      }
   """
)
                        

// @LINE:581
def editarAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.editarAgente",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:579
def crearAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.crearAgente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/crear"})
      }
   """
)
                        

// @LINE:583
def actualizarAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.actualizarAgente",
   """
      function(agenteId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        

// @LINE:586
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:585
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:584
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalBuscar"})
      }
   """
)
                        

// @LINE:1033
def suggestAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.suggestAgente",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestAgente/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:578
def indexAgente : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesController.indexAgente",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente"})
      }
   """
)
                        
    
}
              

// @LINE:521
// @LINE:520
// @LINE:519
// @LINE:518
// @LINE:517
// @LINE:516
class ReverseAgentesNovedadesController {
    

// @LINE:516
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesNovedadesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-novedad/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:521
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesNovedadesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-novedad/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:519
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesNovedadesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-novedad/guardar"})
      }
   """
)
                        

// @LINE:520
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesNovedadesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-novedad/actualizar"})
      }
   """
)
                        

// @LINE:518
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesNovedadesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-novedad/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:517
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesNovedadesController.crear",
   """
      function(agenteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-novedad/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        
    
}
              

// @LINE:535
// @LINE:534
// @LINE:533
// @LINE:532
// @LINE:531
// @LINE:530
class ReverseAgentesFamiliasController {
    

// @LINE:530
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesFamiliasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-familia/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:535
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesFamiliasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-familia/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:533
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesFamiliasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-familia/guardar"})
      }
   """
)
                        

// @LINE:534
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesFamiliasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-familia/actualizar"})
      }
   """
)
                        

// @LINE:532
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesFamiliasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-familia/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:531
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesFamiliasController.crear",
   """
      function(agenteId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente-familia/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        
    
}
              

// @LINE:600
// @LINE:599
// @LINE:598
// @LINE:597
// @LINE:596
// @LINE:595
// @LINE:594
// @LINE:593
// @LINE:592
// @LINE:591
// @LINE:588
// @LINE:587
class ReverseAgentesAccionesController {
    

// @LINE:588
def replicarProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.replicarProveedor",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/replicarProveedor"})
      }
   """
)
                        

// @LINE:596
def pasarACancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.pasarACancelado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/pasarACancelado"})
      }
   """
)
                        

// @LINE:600
def pasarAPreaprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.pasarAPreaprobado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/pasarAPreaprobado"})
      }
   """
)
                        

// @LINE:597
def modalPasarACargado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.modalPasarACargado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalPasarACargado"})
      }
   """
)
                        

// @LINE:594
def pasarABorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.pasarABorrador",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/pasarABorrador"})
      }
   """
)
                        

// @LINE:587
def modalReplicarProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.modalReplicarProveedor",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalReplicarProveedor" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:598
def pasarACargado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.pasarACargado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/pasarACargado"})
      }
   """
)
                        

// @LINE:595
def modalPasarACancelado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.modalPasarACancelado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalPasarACancelado"})
      }
   """
)
                        

// @LINE:591
def modalPasarAAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.modalPasarAAprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalPasarAAprobado"})
      }
   """
)
                        

// @LINE:592
def pasarAAprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.pasarAAprobado",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/pasarAAprobado"})
      }
   """
)
                        

// @LINE:599
def modalPasarAPreaprobado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.modalPasarAPreaprobado",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalPasarAPreaprobado"})
      }
   """
)
                        

// @LINE:593
def modalPasarABorrador : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAccionesController.modalPasarABorrador",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agente/modalPasarABorrador"})
      }
   """
)
                        
    
}
              

// @LINE:1028
// @LINE:554
// @LINE:553
class ReverseProfesionesController {
    

// @LINE:553
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.ProfesionesController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/profesion/modalBuscar"})
      }
   """
)
                        

// @LINE:1028
def suggestProfesion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.ProfesionesController.suggestProfesion",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestProfesion/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:554
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.ProfesionesController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/profesion/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        
    
}
              

// @LINE:498
class ReverseIndexController {
    

// @LINE:498
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh"})
      }
   """
)
                        
    
}
              

// @LINE:1026
// @LINE:542
// @LINE:541
// @LINE:540
// @LINE:539
// @LINE:538
// @LINE:537
// @LINE:500
// @LINE:499
class ReverseDepartamentosController {
    

// @LINE:500
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:539
def guardarDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.guardarDepartamento",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/guardar"})
      }
   """
)
                        

// @LINE:541
def eliminarDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.eliminarDepartamento",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:540
def editarDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.editarDepartamento",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:499
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/modalBuscar"})
      }
   """
)
                        

// @LINE:537
def indexDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.indexDepartamento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento"})
      }
   """
)
                        

// @LINE:1026
def suggestDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.suggestDepartamento",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestDepartamento/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:538
def crearDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.crearDepartamento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/crear"})
      }
   """
)
                        

// @LINE:542
def actualizarDepartamento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.DepartamentosController.actualizarDepartamento",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/departamento/actualizar"})
      }
   """
)
                        
    
}
              

// @LINE:622
// @LINE:621
// @LINE:620
class ReverseAgentesAsistenciasController {
    

// @LINE:621
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteAsistencia/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:620
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteAsistencia/index"})
      }
   """
)
                        

// @LINE:622
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesAsistenciasController.ver",
   """
      function(id,tipoLicencia) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteAsistencia/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (tipoLicencia == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("tipoLicencia", tipoLicencia))])})
      }
   """
)
                        
    
}
              

// @LINE:656
// @LINE:655
// @LINE:654
// @LINE:653
// @LINE:652
// @LINE:651
// @LINE:649
// @LINE:648
class ReverseAgentesSeguimientoController {
    

// @LINE:656
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.cambiarEstado",
   """
      function(idSeguimiento,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idSeguimiento", idSeguimiento), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:654
def actualizarAgenteSeguimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.actualizarAgenteSeguimiento",
   """
      function(agenteId) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("agenteId", agenteId)])})
      }
   """
)
                        

// @LINE:655
def eliminarAgenteSeguimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.eliminarAgenteSeguimiento",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:651
def crearAgenteSeguimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.crearAgenteSeguimiento",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/crear"})
      }
   """
)
                        

// @LINE:653
def editarAgenteSeguimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.editarAgenteSeguimiento",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:649
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:652
def guardarAgenteSeguimiento : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.guardarAgenteSeguimiento",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/guardar"})
      }
   """
)
                        

// @LINE:648
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.AgentesSeguimientoController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/agenteSeguimiento/index"})
      }
   """
)
                        
    
}
              

// @LINE:1030
// @LINE:576
// @LINE:575
// @LINE:574
// @LINE:573
// @LINE:572
// @LINE:571
// @LINE:570
// @LINE:569
class ReversePuestosController {
    

// @LINE:574
def actualizarPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.actualizarPuesto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/actualizar"})
      }
   """
)
                        

// @LINE:569
def indexPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.indexPuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto"})
      }
   """
)
                        

// @LINE:576
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:575
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/modalBuscar"})
      }
   """
)
                        

// @LINE:1030
def suggestPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.suggestPuesto",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestPuesto/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:571
def guardarPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.guardarPuesto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/guardar"})
      }
   """
)
                        

// @LINE:570
def crearPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.crearPuesto",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/crear"})
      }
   """
)
                        

// @LINE:573
def eliminarPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.eliminarPuesto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:572
def editarPuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.rrhh.PuestosController.editarPuesto",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rrhh/puesto/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              
}
        

// @LINE:1054
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
package controllers.javascript {

// @LINE:1054
class ReverseAssets {
    

// @LINE:1054
def at : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.at",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        
    
}
              

// @LINE:17
// @LINE:16
// @LINE:15
class ReverseAuthentication {
    

// @LINE:17
def logout : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.logout",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
      }
   """
)
                        

// @LINE:16
def authenticate : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.authenticate",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        

// @LINE:15
def login : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Authentication.login",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
      }
   """
)
                        
    
}
              

// @LINE:13
class ReverseApplication {
    

// @LINE:13
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:1038
// @LINE:677
// @LINE:676
// @LINE:675
// @LINE:674
// @LINE:673
// @LINE:672
// @LINE:671
// @LINE:670
// @LINE:669
package controllers.delegacion.javascript {

// @LINE:1038
// @LINE:677
// @LINE:676
// @LINE:675
// @LINE:674
// @LINE:673
// @LINE:672
// @LINE:671
// @LINE:670
class ReverseDepositosController {
    

// @LINE:671
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/crear"})
      }
   """
)
                        

// @LINE:677
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:674
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:672
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/guardar"})
      }
   """
)
                        

// @LINE:675
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/actualizar"})
      }
   """
)
                        

// @LINE:676
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/modalBuscar"})
      }
   """
)
                        

// @LINE:1038
def suggestDeposito : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.suggestDeposito",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestDeposito/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:673
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:670
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.DepositosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion/deposito"})
      }
   """
)
                        
    
}
              

// @LINE:669
class ReverseIndexController {
    

// @LINE:669
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.delegacion.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "delegacion"})
      }
   """
)
                        
    
}
              
}
        

// @LINE:1050
// @LINE:1032
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
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
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:22
// @LINE:21
package controllers.administracion.javascript {

// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
class ReverseUsuariosController {
    

// @LINE:33
def suggest : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.suggest",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/suggest/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:28
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/crear"})
      }
   """
)
                        

// @LINE:30
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/editar" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:35
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:29
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:32
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/guardar"})
      }
   """
)
                        

// @LINE:31
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/actualizar"})
      }
   """
)
                        

// @LINE:34
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios/modalBuscar"})
      }
   """
)
                        

// @LINE:27
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.UsuariosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/usuarios"})
      }
   """
)
                        
    
}
              

// @LINE:1050
// @LINE:22
// @LINE:21
class ReverseOrganigramasController {
    

// @LINE:21
def modalBuscarServicios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.OrganigramasController.modalBuscarServicios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/organigrama/modal-buscar-sevicios"})
      }
   """
)
                        

// @LINE:22
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.OrganigramasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/organigrama/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:1050
def suggestOrganigrama : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.OrganigramasController.suggestOrganigrama",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestOrganigrama/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        
    
}
              

// @LINE:38
// @LINE:37
// @LINE:36
class ReversePermisosController {
    

// @LINE:38
def desasignar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.PermisosController.desasignar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/desasignar"})
      }
   """
)
                        

// @LINE:36
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.PermisosController.index",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/permisos" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:37
def asignar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.PermisosController.asignar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/asignar"})
      }
   """
)
                        
    
}
              

// @LINE:39
class ReverseProvinciasController {
    

// @LINE:39
def listOptions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.ProvinciasController.listOptions",
   """
      function(paisId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/provincias/listOptions" + _qS([(paisId == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("paisId", paisId))])})
      }
   """
)
                        
    
}
              

// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
class ReverseTicketsController {
    

// @LINE:56
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.cambiarEstado",
   """
      function(id,estado_id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("estado_id", estado_id)])})
      }
   """
)
                        

// @LINE:52
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/crear"})
      }
   """
)
                        

// @LINE:57
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:58
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:53
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/guardar"})
      }
   """
)
                        

// @LINE:55
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/actualizar"})
      }
   """
)
                        

// @LINE:54
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:51
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.TicketsController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/tickets"})
      }
   """
)
                        
    
}
              

// @LINE:26
class ReverseIndexController {
    

// @LINE:26
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion"})
      }
   """
)
                        
    
}
              

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
class ReverseGruposController {
    

// @LINE:42
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/crear"})
      }
   """
)
                        

// @LINE:44
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/editar" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:48
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:43
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Integer]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:46
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/guardar"})
      }
   """
)
                        

// @LINE:45
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/actualizar"})
      }
   """
)
                        

// @LINE:47
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos/modalBuscar"})
      }
   """
)
                        

// @LINE:41
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.GruposController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/grupos"})
      }
   """
)
                        
    
}
              

// @LINE:1032
// @LINE:40
class ReverseLocalidadesController {
    

// @LINE:1032
def suggestLocalidad : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.LocalidadesController.suggestLocalidad",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestLocalidad/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:40
def listOptions : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.administracion.LocalidadesController.listOptions",
   """
      function(provinciaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "administracion/localidades/listOptions" + _qS([(provinciaId == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("provinciaId", provinciaId))])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:1052
// @LINE:1042
// @LINE:1025
// @LINE:494
// @LINE:493
// @LINE:492
// @LINE:491
// @LINE:490
// @LINE:489
// @LINE:488
// @LINE:487
// @LINE:486
// @LINE:485
// @LINE:484
// @LINE:482
// @LINE:481
// @LINE:480
// @LINE:479
// @LINE:478
// @LINE:477
// @LINE:476
// @LINE:474
// @LINE:473
// @LINE:472
// @LINE:471
// @LINE:470
// @LINE:469
// @LINE:467
// @LINE:466
// @LINE:465
// @LINE:464
// @LINE:463
// @LINE:462
// @LINE:460
// @LINE:459
// @LINE:458
// @LINE:457
// @LINE:456
// @LINE:455
// @LINE:454
// @LINE:453
// @LINE:452
// @LINE:451
// @LINE:450
// @LINE:449
// @LINE:448
// @LINE:447
// @LINE:446
// @LINE:445
// @LINE:444
// @LINE:443
// @LINE:442
// @LINE:441
// @LINE:439
// @LINE:438
// @LINE:437
// @LINE:436
// @LINE:435
// @LINE:434
// @LINE:433
// @LINE:432
// @LINE:431
// @LINE:430
package controllers.expediente.ref {


// @LINE:1052
// @LINE:1042
// @LINE:460
// @LINE:459
// @LINE:458
// @LINE:457
// @LINE:456
// @LINE:455
// @LINE:454
// @LINE:453
// @LINE:452
// @LINE:451
// @LINE:450
// @LINE:449
// @LINE:448
// @LINE:447
// @LINE:446
// @LINE:445
// @LINE:444
// @LINE:443
// @LINE:442
// @LINE:441
class ReverseExpedientesController {
    

// @LINE:449
def modalBuscarCopia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.modalBuscarCopia(), HandlerDef(this, "controllers.expediente.ExpedientesController", "modalBuscarCopia", Seq(), "GET", """""", _prefix + """expediente/expediente/modalBuscarCopia""")
)
                      

// @LINE:453
def reporteTapaExpediente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.reporteTapaExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "reporteTapaExpediente", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/reporteTapaExpediente""")
)
                      

// @LINE:452
def reporteTapaExpedienteMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.reporteTapaExpedienteMasivo(), HandlerDef(this, "controllers.expediente.ExpedientesController", "reporteTapaExpedienteMasivo", Seq(), "POST", """""", _prefix + """expediente/reporteTapaExpedienteMasiva""")
)
                      

// @LINE:444
def editarExpediente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.editarExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "editarExpediente", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/expediente/editar""")
)
                      

// @LINE:1052
def suggestExpedienteCopia(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.suggestExpedienteCopia(input), HandlerDef(this, "controllers.expediente.ExpedientesController", "suggestExpedienteCopia", Seq(classOf[String]), "GET", """""", _prefix + """suggestExpedienteCopia/$input<[^/]+>""")
)
                      

// @LINE:442
def crearExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.crearExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "crearExpediente", Seq(), "GET", """""", _prefix + """expediente/expediente/crear""")
)
                      

// @LINE:455
def crearCopia(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.crearCopia(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "crearCopia", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/expediente/crearCopia""")
)
                      

// @LINE:450
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.get(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """expediente/expediente/get""")
)
                      

// @LINE:451
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.ver(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/expediente/ver""")
)
                      

// @LINE:454
def listadoExpedientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.listadoExpedientes(), HandlerDef(this, "controllers.expediente.ExpedientesController", "listadoExpedientes", Seq(), "POST", """""", _prefix + """expediente/reporteListadoExpedientes""")
)
                      

// @LINE:459
def getExpedientesSinFirma(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.getExpedientesSinFirma(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesSinFirma", Seq(), "GET", """""", _prefix + """expediente/getExpedientesSinFirma""")
)
                      

// @LINE:1042
def suggestExpediente(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.suggestExpediente(input), HandlerDef(this, "controllers.expediente.ExpedientesController", "suggestExpediente", Seq(classOf[String]), "GET", """""", _prefix + """suggestExpediente/$input<[^/]+>""")
)
                      

// @LINE:458
def getExpedientesRecepcionSinFirmaReporte(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirmaReporte(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesRecepcionSinFirmaReporte", Seq(), "GET", """""", _prefix + """expediente/getExpedientesRecepcionSinFirmaReporte""")
)
                      

// @LINE:448
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.modalBuscar(), HandlerDef(this, "controllers.expediente.ExpedientesController", "modalBuscar", Seq(), "GET", """""", _prefix + """expediente/expediente/modalBuscar""")
)
                      

// @LINE:443
def guardarExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.guardarExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "guardarExpediente", Seq(), "POST", """""", _prefix + """expediente/expediente/guardar""")
)
                      

// @LINE:445
def eliminarExpediente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.eliminarExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "eliminarExpediente", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/expediente/eliminar""")
)
                      

// @LINE:457
def getExpedientesRecepcionSinFirma(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.getExpedientesRecepcionSinFirma(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesRecepcionSinFirma", Seq(), "GET", """""", _prefix + """expediente/getExpedientesRecepcionSinFirma""")
)
                      

// @LINE:447
def actualizarExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.actualizarExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "actualizarExpediente", Seq(), "POST", """""", _prefix + """expediente/expediente/actualizar""")
)
                      

// @LINE:456
def crearRP(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.crearRP(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "crearRP", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/expediente/crearRP""")
)
                      

// @LINE:460
def getExpedientesSinFirmaReporte(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.getExpedientesSinFirmaReporte(), HandlerDef(this, "controllers.expediente.ExpedientesController", "getExpedientesSinFirmaReporte", Seq(), "GET", """""", _prefix + """expediente/getExpedientesSinFirmaReporte""")
)
                      

// @LINE:441
def indexExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.indexExpediente(), HandlerDef(this, "controllers.expediente.ExpedientesController", "indexExpediente", Seq(), "GET", """""", _prefix + """expediente/expediente""")
)
                      

// @LINE:446
def eliminarExpedienteCopia(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesController.eliminarExpedienteCopia(id), HandlerDef(this, "controllers.expediente.ExpedientesController", "eliminarExpedienteCopia", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/expediente/eliminarCopia""")
)
                      
    
}
                          

// @LINE:494
// @LINE:493
// @LINE:492
// @LINE:491
// @LINE:490
// @LINE:489
// @LINE:488
// @LINE:487
// @LINE:486
// @LINE:485
// @LINE:484
class ReverseDisposController {
    

// @LINE:493
def getDisposPorExpediente(expedienteId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.getDisposPorExpediente(expedienteId), HandlerDef(this, "controllers.expediente.DisposController", "getDisposPorExpediente", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/dispo/getDisposPorExpediente""")
)
                      

// @LINE:494
def cambiarEstado(idDispo:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.cambiarEstado(idDispo, idEstado), HandlerDef(this, "controllers.expediente.DisposController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """expediente/dispo/cambiarEstado""")
)
                      

// @LINE:485
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.crear(), HandlerDef(this, "controllers.expediente.DisposController", "crear", Seq(), "GET", """""", _prefix + """expediente/dispo/crear""")
)
                      

// @LINE:492
def getLastNumeroDispoByOrden(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.getLastNumeroDispoByOrden(), HandlerDef(this, "controllers.expediente.DisposController", "getLastNumeroDispoByOrden", Seq(), "POST", """""", _prefix + """expediente/dispo/getLastNumeroDispoByOrden""")
)
                      

// @LINE:490
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.ver(id), HandlerDef(this, "controllers.expediente.DisposController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/dispo/ver""")
)
                      

// @LINE:489
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.eliminar(id), HandlerDef(this, "controllers.expediente.DisposController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/dispo/eliminar""")
)
                      

// @LINE:491
def getLastNumeroDispo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.getLastNumeroDispo(), HandlerDef(this, "controllers.expediente.DisposController", "getLastNumeroDispo", Seq(), "POST", """""", _prefix + """expediente/dispo/getLastNumeroDispo""")
)
                      

// @LINE:486
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.guardar(), HandlerDef(this, "controllers.expediente.DisposController", "guardar", Seq(), "POST", """""", _prefix + """expediente/dispo/guardar""")
)
                      

// @LINE:488
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.actualizar(), HandlerDef(this, "controllers.expediente.DisposController", "actualizar", Seq(), "POST", """""", _prefix + """expediente/dispo/actualizar""")
)
                      

// @LINE:487
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.editar(id), HandlerDef(this, "controllers.expediente.DisposController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/dispo/editar""")
)
                      

// @LINE:484
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.DisposController.index(), HandlerDef(this, "controllers.expediente.DisposController", "index", Seq(), "GET", """""", _prefix + """expediente/dispo""")
)
                      
    
}
                          

// @LINE:1025
// @LINE:438
// @LINE:437
// @LINE:436
// @LINE:435
// @LINE:434
// @LINE:433
// @LINE:432
// @LINE:431
class ReverseIniciadorExpedientesController {
    

// @LINE:435
def eliminarIniciadorExpediente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.eliminarIniciadorExpediente(id), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "eliminarIniciadorExpediente", Seq(classOf[Long]), "GET", """""", _prefix + """expedient/iniciadorExpediente/eliminar""")
)
                      

// @LINE:436
def actualizarIniciadorExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.actualizarIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "actualizarIniciadorExpediente", Seq(), "POST", """""", _prefix + """expediente/iniciadorExpediente/actualizar""")
)
                      

// @LINE:1025
def suggestIniciadorExpediente(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.suggestIniciadorExpediente(input), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "suggestIniciadorExpediente", Seq(classOf[String]), "GET", """""", _prefix + """suggestIniciador/$input<[^/]+>""")
)
                      

// @LINE:438
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.get(id), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """expediente/iniciadorExpediente/get""")
)
                      

// @LINE:433
def guardarIniciadorExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.guardarIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "guardarIniciadorExpediente", Seq(), "POST", """""", _prefix + """expediente/iniciadorExpediente/guardar""")
)
                      

// @LINE:432
def crearIniciadorExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.crearIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "crearIniciadorExpediente", Seq(), "GET", """""", _prefix + """expediente/iniciadorExpediente/crear""")
)
                      

// @LINE:437
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.modalBuscar(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "modalBuscar", Seq(), "GET", """""", _prefix + """expediente/iniciadorExpediente/modalBuscar""")
)
                      

// @LINE:434
def editarIniciadorExpediente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.editarIniciadorExpediente(id), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "editarIniciadorExpediente", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/iniciadorExpediente/editar""")
)
                      

// @LINE:431
def indexIniciadorExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IniciadorExpedientesController.indexIniciadorExpediente(), HandlerDef(this, "controllers.expediente.IniciadorExpedientesController", "indexIniciadorExpediente", Seq(), "GET", """""", _prefix + """expediente/iniciadorExpediente""")
)
                      
    
}
                          

// @LINE:430
class ReverseIndexController {
    

// @LINE:430
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.IndexController.index(), HandlerDef(this, "controllers.expediente.IndexController", "index", Seq(), "GET", """-----------------------------MODULO EXPEDIENTES ---------------------------------""", _prefix + """expediente""")
)
                      
    
}
                          

// @LINE:467
// @LINE:466
// @LINE:465
// @LINE:464
// @LINE:463
// @LINE:462
class ReverseExpedientesMovimientosController {
    

// @LINE:462
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMovimientosController.index(id, editable), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """expediente/movimiento-linea/index""")
)
                      

// @LINE:467
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMovimientosController.eliminar(id), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/movimiento-linea/eliminar""")
)
                      

// @LINE:465
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMovimientosController.guardar(), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "guardar", Seq(), "POST", """""", _prefix + """expediente/movimiento-linea/guardar""")
)
                      

// @LINE:466
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMovimientosController.actualizar(), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "actualizar", Seq(), "POST", """""", _prefix + """expediente/movimiento-linea/actualizar""")
)
                      

// @LINE:464
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMovimientosController.editar(id), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/movimiento-linea/editar""")
)
                      

// @LINE:463
def crear(expedienteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMovimientosController.crear(expedienteId), HandlerDef(this, "controllers.expediente.ExpedientesMovimientosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """expediente/movimiento-linea/crear""")
)
                      
    
}
                          

// @LINE:476
// @LINE:474
// @LINE:473
// @LINE:472
// @LINE:439
class ReverseExpedientesReportesController {
    

// @LINE:476
def reportePaseExpedienteLista(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesReportesController.reportePaseExpedienteLista(), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpedienteLista", Seq(), "POST", """""", _prefix + """expediente/reportes/reportePaseExpedienteLista""")
)
                      

// @LINE:472
def reportePaseExpediente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesReportesController.reportePaseExpediente(id), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpediente", Seq(classOf[Long]), "POST", """""", _prefix + """expediente/reportes/reportePaseExpediente""")
)
                      

// @LINE:439
def reporteMovimiento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesReportesController.reporteMovimiento(), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reporteMovimiento", Seq(), "GET", """""", _prefix + """expediente/reportes/reporteMovimiento""")
)
                      

// @LINE:474
def reportePaseExpedienteListaCodigo(codigo:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigo(codigo), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpedienteListaCodigo", Seq(classOf[Int]), "POST", """""", _prefix + """expediente/reportes/reportePaseExpedienteCodigo""")
)
                      

// @LINE:473
def reportePaseExpedienteListaCodigoCombinado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesReportesController.reportePaseExpedienteListaCodigoCombinado(), HandlerDef(this, "controllers.expediente.ExpedientesReportesController", "reportePaseExpedienteListaCodigoCombinado", Seq(), "POST", """""", _prefix + """expediente/reportes/reportePaseExpedienteLista""")
)
                      
    
}
                          

// @LINE:480
class ReverseExpedientesMisPasesController {
    

// @LINE:480
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesMisPasesController.index(), HandlerDef(this, "controllers.expediente.ExpedientesMisPasesController", "index", Seq(), "GET", """""", _prefix + """expediente/expedienteMisPases""")
)
                      
    
}
                          

// @LINE:482
// @LINE:481
// @LINE:479
// @LINE:478
// @LINE:477
// @LINE:471
// @LINE:470
// @LINE:469
class ReverseExpedientesAccionesController {
    

// @LINE:477
def cancelarPase(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.cancelarPase(id), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "cancelarPase", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/acciones/cancelarPase""")
)
                      

// @LINE:470
def modalPasarOtroServicioIndividual(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicioIndividual(id), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "modalPasarOtroServicioIndividual", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/acciones/modalPasarOtroServicioIndividual""")
)
                      

// @LINE:479
def asignarMiServicio(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.asignarMiServicio(id), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "asignarMiServicio", Seq(classOf[Long]), "GET", """""", _prefix + """expediente/acciones/asignarMiServicio""")
)
                      

// @LINE:471
def pasarOtroServicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.pasarOtroServicio(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "pasarOtroServicio", Seq(), "POST", """""", _prefix + """expediente/acciones/pasarOtroServicio""")
)
                      

// @LINE:478
def cancelarPaseLista(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.cancelarPaseLista(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "cancelarPaseLista", Seq(), "POST", """""", _prefix + """expediente/acciones/cancelarPaseLista""")
)
                      

// @LINE:469
def modalPasarOtroServicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.modalPasarOtroServicio(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "modalPasarOtroServicio", Seq(), "GET", """""", _prefix + """expediente/acciones/modalPasarOtroServicio""")
)
                      

// @LINE:482
def modalAsignarMiServicio(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.modalAsignarMiServicio(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "modalAsignarMiServicio", Seq(), "GET", """""", _prefix + """expediente/acciones/modalAsignarMiServicio""")
)
                      

// @LINE:481
def asignarAMiServicioMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.expediente.ExpedientesAccionesController.asignarAMiServicioMasivo(), HandlerDef(this, "controllers.expediente.ExpedientesAccionesController", "asignarAMiServicioMasivo", Seq(), "POST", """""", _prefix + """expediente/acciones/asignarMiServicioMasivo""")
)
                      
    
}
                          
}
        

// @LINE:729
// @LINE:728
// @LINE:726
// @LINE:725
// @LINE:722
// @LINE:721
// @LINE:720
// @LINE:718
// @LINE:716
// @LINE:715
// @LINE:714
// @LINE:713
// @LINE:711
// @LINE:710
// @LINE:709
// @LINE:708
// @LINE:707
// @LINE:706
// @LINE:705
// @LINE:704
// @LINE:703
// @LINE:702
// @LINE:701
// @LINE:700
// @LINE:699
// @LINE:698
// @LINE:697
// @LINE:695
// @LINE:693
// @LINE:691
// @LINE:690
// @LINE:689
// @LINE:687
// @LINE:686
// @LINE:685
// @LINE:684
// @LINE:683
// @LINE:682
// @LINE:681
package controllers.presupuesto.ref {


// @LINE:709
// @LINE:708
// @LINE:707
// @LINE:706
// @LINE:705
// @LINE:704
class ReverseLineasRecursosPresupuestariosController {
    

// @LINE:704
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasRecursosPresupuestariosController.index(id, editable), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """presupuesto/linea-recurso/index""")
)
                      

// @LINE:709
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasRecursosPresupuestariosController.eliminar(id), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/linea-recurso/eliminar""")
)
                      

// @LINE:707
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasRecursosPresupuestariosController.guardar(), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "guardar", Seq(), "POST", """""", _prefix + """presupuesto/linea-recurso/guardar""")
)
                      

// @LINE:708
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasRecursosPresupuestariosController.actualizar(), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "actualizar", Seq(), "POST", """""", _prefix + """presupuesto/linea-recurso/actualizar""")
)
                      

// @LINE:706
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasRecursosPresupuestariosController.editar(id), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/linea-recurso/editar""")
)
                      

// @LINE:705
def crear(creditoPresupuestarioId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasRecursosPresupuestariosController.crear(creditoPresupuestarioId), HandlerDef(this, "controllers.presupuesto.LineasRecursosPresupuestariosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """presupuesto/linea-recurso/crear""")
)
                      
    
}
                          

// @LINE:703
// @LINE:702
// @LINE:701
// @LINE:700
// @LINE:699
// @LINE:698
class ReverseLineasCreditosPresupuestariosController {
    

// @LINE:698
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasCreditosPresupuestariosController.index(id, editable), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """presupuesto/linea-credito/index""")
)
                      

// @LINE:703
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasCreditosPresupuestariosController.eliminar(id), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/linea-credito/eliminar""")
)
                      

// @LINE:701
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasCreditosPresupuestariosController.guardar(), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "guardar", Seq(), "POST", """""", _prefix + """presupuesto/linea-credito/guardar""")
)
                      

// @LINE:702
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasCreditosPresupuestariosController.actualizar(), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "actualizar", Seq(), "POST", """""", _prefix + """presupuesto/linea-credito/actualizar""")
)
                      

// @LINE:700
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasCreditosPresupuestariosController.editar(id), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/linea-credito/editar""")
)
                      

// @LINE:699
def crear(creditoPresupuestarioId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.LineasCreditosPresupuestariosController.crear(creditoPresupuestarioId), HandlerDef(this, "controllers.presupuesto.LineasCreditosPresupuestariosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """presupuesto/linea-credito/crear""")
)
                      
    
}
                          

// @LINE:711
// @LINE:710
class ReverseBalancePresupuestarioController {
    

// @LINE:711
def balancePresupuestarioPorExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioController.balancePresupuestarioPorExpediente(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioController", "balancePresupuestarioPorExpediente", Seq(), "GET", """""", _prefix + """presupuesto/balancePresupuestarioPorExpediente""")
)
                      

// @LINE:710
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioController.index(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioController", "index", Seq(), "GET", """""", _prefix + """presupuesto/balance-presupuestario""")
)
                      
    
}
                          

// @LINE:697
// @LINE:695
// @LINE:693
// @LINE:691
// @LINE:690
// @LINE:689
// @LINE:687
// @LINE:686
// @LINE:685
// @LINE:684
// @LINE:683
// @LINE:682
class ReverseCreditosPresupuestariosController {
    

// @LINE:691
def aprobar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.aprobar(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "aprobar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/aprobar""")
)
                      

// @LINE:693
def listaCargas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.listaCargas(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "listaCargas", Seq(), "GET", """""", _prefix + """presupuesto/credito-listaCargas""")
)
                      

// @LINE:683
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.crear(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "crear", Seq(), "GET", """""", _prefix + """presupuesto/credito-presupuestario/crear""")
)
                      

// @LINE:689
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.get(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "get", Seq(classOf[Int]), "GET", """GET    /presupuesto/credito-presupuestario/modalBuscar			controllers.presupuesto.CreditosPresupuestariosController.modalBuscar()""", _prefix + """presupuesto/credito-presupuestario/get""")
)
                      

// @LINE:690
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.ver(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/credito-presupuestario/ver""")
)
                      

// @LINE:686
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.eliminar(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/credito-presupuestario/eliminar""")
)
                      

// @LINE:684
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.guardar(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "guardar", Seq(), "POST", """""", _prefix + """presupuesto/credito-presupuestario/guardar""")
)
                      

// @LINE:687
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.actualizar(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "actualizar", Seq(), "POST", """""", _prefix + """presupuesto/credito-presupuestario/actualizar""")
)
                      

// @LINE:685
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.editar(id), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/credito-presupuestario/editar""")
)
                      

// @LINE:697
def reporteListadoCreditos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.reporteListadoCreditos(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "reporteListadoCreditos", Seq(), "POST", """""", _prefix + """presupuesto/credito-presupuestario/reporteListadoCreditos""")
)
                      

// @LINE:682
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.CreditosPresupuestariosController.index(), HandlerDef(this, "controllers.presupuesto.CreditosPresupuestariosController", "index", Seq(), "GET", """""", _prefix + """presupuesto/credito-presupuestario""")
)
                      
    
}
                          

// @LINE:681
class ReverseIndexController {
    

// @LINE:681
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.IndexController.index(), HandlerDef(this, "controllers.presupuesto.IndexController", "index", Seq(), "GET", """-----------------------------MODULO PRESUPUESTO ---------------------------------""", _prefix + """presupuesto""")
)
                      
    
}
                          

// @LINE:729
// @LINE:728
// @LINE:726
// @LINE:725
class ReverseControlPresupuestarioController {
    

// @LINE:729
def movimientosSaldoPreventivoExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivoExcel(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "movimientosSaldoPreventivoExcel", Seq(), "GET", """""", _prefix + """presupuesto/movimientosSaldoPreventivoExcel""")
)
                      

// @LINE:728
def movimientosSaldoPreventivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.ControlPresupuestarioController.movimientosSaldoPreventivo(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "movimientosSaldoPreventivo", Seq(), "GET", """""", _prefix + """presupuesto/movimientosSaldoPreventivo""")
)
                      

// @LINE:726
def controlAnulacionProductosAutomaticosExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticosExcel(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "controlAnulacionProductosAutomaticosExcel", Seq(), "GET", """""", _prefix + """presupuesto/controlAnulacionProductosAutomaticosExcel""")
)
                      

// @LINE:725
def controlAnulacionProductosAutomaticos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.ControlPresupuestarioController.controlAnulacionProductosAutomaticos(), HandlerDef(this, "controllers.presupuesto.ControlPresupuestarioController", "controlAnulacionProductosAutomaticos", Seq(), "GET", """""", _prefix + """presupuesto/controlAnulacionProductosAutomaticos""")
)
                      
    
}
                          

// @LINE:722
// @LINE:721
// @LINE:720
// @LINE:718
// @LINE:716
// @LINE:715
// @LINE:714
// @LINE:713
class ReverseBalancePresupuestarioReportesController {
    

// @LINE:715
def modalReporteExportarDatosPresupuestoControl(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteExportarDatosPresupuestoControl(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "modalReporteExportarDatosPresupuestoControl", Seq(), "GET", """""", _prefix + """presupuesto/reporte/modalReporteExportarDatosPresupuestoControl""")
)
                      

// @LINE:718
def reporteBalanceDiferenciaPreventivoDefinitivo(idEjercicio:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalanceDiferenciaPreventivoDefinitivo(idEjercicio), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalanceDiferenciaPreventivoDefinitivo", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto/reporte/reporteBalanceDiferenciaPreventivoDefinitivo""")
)
                      

// @LINE:716
def reporteExportarDatosPresupuestoControl(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.reporteExportarDatosPresupuestoControl(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteExportarDatosPresupuestoControl", Seq(), "POST", """""", _prefix + """presupuesto/reporte/reporteExportarDatosPresupuestoControl""")
)
                      

// @LINE:713
def modalReporteBalancePorCuentaPorExpediente(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorCuentaPorExpediente(id), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "modalReporteBalancePorCuentaPorExpediente", Seq(classOf[Integer]), "GET", """""", _prefix + """presupuesto/reporte/modalReporteBalancePorCuentaPorExpediente""")
)
                      

// @LINE:721
def reporteBalancePorFecha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFecha(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalancePorFecha", Seq(), "POST", """""", _prefix + """presupuesto/reporteBalancePorFecha""")
)
                      

// @LINE:714
def reporteBalancePorCuentaPorExpediente(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorCuentaPorExpediente(id), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalancePorCuentaPorExpediente", Seq(classOf[Integer]), "POST", """""", _prefix + """presupuesto/reporte/reporteBalancePorCuentaPorExpediente""")
)
                      

// @LINE:720
def modalReporteBalancePorFecha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.modalReporteBalancePorFecha(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "modalReporteBalancePorFecha", Seq(), "GET", """""", _prefix + """presupuesto/modalReporteBalancePorFecha""")
)
                      

// @LINE:722
def reporteBalancePorFechaPorExpediente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.presupuesto.BalancePresupuestarioReportesController.reporteBalancePorFechaPorExpediente(), HandlerDef(this, "controllers.presupuesto.BalancePresupuestarioReportesController", "reporteBalancePorFechaPorExpediente", Seq(), "POST", """""", _prefix + """presupuesto/reporteBalancePorFechaPorExpediente""")
)
                      
    
}
                          
}
        

// @LINE:1048
// @LINE:1047
// @LINE:1046
// @LINE:1018
// @LINE:1012
// @LINE:1010
// @LINE:1009
// @LINE:1008
// @LINE:1006
// @LINE:1005
// @LINE:1004
// @LINE:1003
// @LINE:1002
// @LINE:1001
// @LINE:1000
// @LINE:998
// @LINE:997
// @LINE:996
// @LINE:995
// @LINE:994
// @LINE:993
// @LINE:992
// @LINE:991
// @LINE:990
// @LINE:988
// @LINE:987
// @LINE:986
// @LINE:985
// @LINE:984
// @LINE:983
// @LINE:982
// @LINE:981
// @LINE:980
// @LINE:979
// @LINE:978
// @LINE:977
// @LINE:976
// @LINE:975
// @LINE:974
// @LINE:973
// @LINE:972
// @LINE:971
// @LINE:970
// @LINE:969
// @LINE:968
// @LINE:967
// @LINE:966
// @LINE:965
// @LINE:964
// @LINE:963
// @LINE:962
// @LINE:961
// @LINE:960
// @LINE:957
// @LINE:956
// @LINE:954
// @LINE:953
// @LINE:952
// @LINE:951
// @LINE:950
// @LINE:949
// @LINE:948
// @LINE:947
// @LINE:946
// @LINE:944
// @LINE:943
// @LINE:942
// @LINE:941
// @LINE:940
// @LINE:939
// @LINE:938
// @LINE:937
// @LINE:936
// @LINE:934
// @LINE:933
// @LINE:932
// @LINE:931
// @LINE:930
// @LINE:929
// @LINE:928
// @LINE:927
// @LINE:926
// @LINE:924
// @LINE:923
// @LINE:922
// @LINE:921
// @LINE:920
// @LINE:919
// @LINE:918
// @LINE:917
// @LINE:916
// @LINE:915
// @LINE:913
// @LINE:912
// @LINE:911
// @LINE:910
// @LINE:909
// @LINE:908
// @LINE:907
// @LINE:906
// @LINE:905
// @LINE:903
// @LINE:902
// @LINE:901
// @LINE:900
// @LINE:899
// @LINE:898
// @LINE:897
// @LINE:896
// @LINE:895
// @LINE:893
// @LINE:892
// @LINE:891
// @LINE:890
// @LINE:889
// @LINE:888
// @LINE:886
// @LINE:885
// @LINE:884
// @LINE:883
// @LINE:882
// @LINE:881
// @LINE:880
// @LINE:879
// @LINE:878
// @LINE:877
// @LINE:875
// @LINE:874
// @LINE:872
// @LINE:871
// @LINE:870
// @LINE:869
// @LINE:868
// @LINE:867
// @LINE:866
// @LINE:865
// @LINE:864
// @LINE:863
// @LINE:862
// @LINE:861
// @LINE:860
// @LINE:859
// @LINE:858
// @LINE:856
// @LINE:855
// @LINE:854
// @LINE:853
// @LINE:852
// @LINE:851
// @LINE:850
// @LINE:849
// @LINE:848
// @LINE:847
// @LINE:845
// @LINE:844
// @LINE:843
// @LINE:842
// @LINE:841
// @LINE:840
// @LINE:839
// @LINE:838
// @LINE:837
// @LINE:835
// @LINE:834
// @LINE:833
// @LINE:832
// @LINE:831
// @LINE:830
// @LINE:829
// @LINE:828
// @LINE:827
// @LINE:825
// @LINE:824
// @LINE:823
// @LINE:822
// @LINE:821
// @LINE:820
// @LINE:819
// @LINE:818
// @LINE:817
// @LINE:815
// @LINE:814
// @LINE:813
// @LINE:812
// @LINE:811
// @LINE:810
// @LINE:809
// @LINE:808
// @LINE:807
// @LINE:805
// @LINE:804
// @LINE:803
// @LINE:802
// @LINE:801
// @LINE:800
// @LINE:799
// @LINE:798
// @LINE:797
// @LINE:795
// @LINE:794
// @LINE:793
// @LINE:792
// @LINE:791
// @LINE:790
// @LINE:789
// @LINE:788
// @LINE:787
// @LINE:784
// @LINE:783
// @LINE:781
// @LINE:780
// @LINE:778
// @LINE:777
// @LINE:776
// @LINE:775
// @LINE:774
// @LINE:773
// @LINE:772
// @LINE:771
// @LINE:770
// @LINE:766
// @LINE:765
// @LINE:764
// @LINE:763
// @LINE:762
// @LINE:761
// @LINE:760
// @LINE:759
// @LINE:758
// @LINE:757
// @LINE:756
// @LINE:753
// @LINE:752
// @LINE:750
// @LINE:749
// @LINE:748
// @LINE:747
// @LINE:746
// @LINE:745
// @LINE:744
// @LINE:743
// @LINE:742
package controllers.haberes.ref {


// @LINE:795
// @LINE:794
// @LINE:793
// @LINE:792
// @LINE:791
// @LINE:790
// @LINE:789
// @LINE:788
// @LINE:787
class ReversePuestosLaboralesReportesController {
    

// @LINE:788
def altasMacroSueldo(nuevo:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.altasMacroSueldo(nuevo), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "altasMacroSueldo", Seq(classOf[Boolean]), "POST", """""", _prefix + """haberes/puestos-laborales/reportes/alta-macrosueldo""")
)
                      

// @LINE:795
def formulario6492022(id:Long, ejercicio_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.formulario6492022(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario6492022", Seq(classOf[Long], classOf[Int]), "GET", """""", _prefix + """reportes/formulario649-2022""")
)
                      

// @LINE:790
def listadoPuestosLaborales(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.listadoPuestosLaborales(), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "listadoPuestosLaborales", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/reportes/listado""")
)
                      

// @LINE:787
def altasMasivas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.altasMasivas(), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "altasMasivas", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/reportes/alta-masiva""")
)
                      

// @LINE:792
def formulario649(id:Long, ejercicio_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.formulario649(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario649", Seq(classOf[Long], classOf[Int]), "GET", """""", _prefix + """reportes/formulario649""")
)
                      

// @LINE:794
def formulario6492021(id:Long, ejercicio_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.formulario6492021(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario6492021", Seq(classOf[Long], classOf[Int]), "GET", """""", _prefix + """reportes/formulario649-2021""")
)
                      

// @LINE:793
def formulario6492019(id:Long, ejercicio_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.formulario6492019(id, ejercicio_id), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "formulario6492019", Seq(classOf[Long], classOf[Int]), "GET", """""", _prefix + """reportes/formulario649-2019""")
)
                      

// @LINE:791
def reportef649(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.reportef649(), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "reportef649", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/reportes/f649""")
)
                      

// @LINE:789
def descargarArchivo(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesReportesController.descargarArchivo(url), HandlerDef(this, "controllers.haberes.PuestosLaboralesReportesController", "descargarArchivo", Seq(classOf[String]), "GET", """""", _prefix + """haberes/puestos-laborales/reportes/descargar-archivo""")
)
                      
    
}
                          

// @LINE:856
// @LINE:855
// @LINE:854
// @LINE:853
// @LINE:852
// @LINE:851
// @LINE:850
// @LINE:849
// @LINE:848
// @LINE:847
class ReverseCategoriasLaboralesController {
    

// @LINE:848
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.crear(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "crear", Seq(), "GET", """""", _prefix + """haberes/categoriaLaboral/crear""")
)
                      

// @LINE:854
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.get(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/categoriaLaboral/get""")
)
                      

// @LINE:855
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/categoriaLaboral/ver""")
)
                      

// @LINE:851
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/categoriaLaboral/eliminar""")
)
                      

// @LINE:849
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/categoriaLaboral/guardar""")
)
                      

// @LINE:852
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/categoriaLaboral/actualizar""")
)
                      

// @LINE:853
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/categoriaLaboral/modalBuscar""")
)
                      

// @LINE:856
def suggestCategoriaLaboral(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.suggestCategoriaLaboral(input), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "suggestCategoriaLaboral", Seq(classOf[String]), "GET", """""", _prefix + """haberes/categoriaLaboral/suggestCategoriaLaboral/$input<[^/]+>""")
)
                      

// @LINE:850
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/categoriaLaboral/editar""")
)
                      

// @LINE:847
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CategoriasLaboralesController.index(), HandlerDef(this, "controllers.haberes.CategoriasLaboralesController", "index", Seq(), "GET", """""", _prefix + """haberes/categoriaLaboral""")
)
                      
    
}
                          

// @LINE:954
// @LINE:953
// @LINE:952
// @LINE:951
// @LINE:950
// @LINE:949
// @LINE:948
// @LINE:947
// @LINE:946
class ReverseInstrumentosLegalesController {
    

// @LINE:947
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.crear(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "crear", Seq(), "GET", """""", _prefix + """haberes/instrumento/crear""")
)
                      

// @LINE:953
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.get(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/instrumento/get""")
)
                      

// @LINE:954
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.ver(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/instrumento/ver""")
)
                      

// @LINE:950
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.eliminar(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/instrumento/eliminar""")
)
                      

// @LINE:948
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.guardar(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/instrumento/guardar""")
)
                      

// @LINE:951
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.actualizar(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/instrumento/actualizar""")
)
                      

// @LINE:952
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.modalBuscar(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/instrumento/modalBuscar""")
)
                      

// @LINE:949
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.editar(id), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/instrumento/editar""")
)
                      

// @LINE:946
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.InstrumentosLegalesController.index(), HandlerDef(this, "controllers.haberes.InstrumentosLegalesController", "index", Seq(), "GET", """""", _prefix + """haberes/instrumento""")
)
                      
    
}
                          

// @LINE:1006
// @LINE:1005
// @LINE:1004
// @LINE:1003
// @LINE:1002
// @LINE:1001
// @LINE:1000
class ReverseEscalasLaboralesMontosController {
    

// @LINE:1001
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.crear(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "crear", Seq(), "GET", """""", _prefix + """haberes/escalaLaboralMonto/crear""")
)
                      

// @LINE:1006
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.ver(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/escalaLaboralMonto/ver""")
)
                      

// @LINE:1004
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.eliminar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/escalaLaboralMonto/eliminar""")
)
                      

// @LINE:1002
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.guardar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/escalaLaboralMonto/guardar""")
)
                      

// @LINE:1005
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.actualizar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/escalaLaboralMonto/actualizar""")
)
                      

// @LINE:1003
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.editar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/escalaLaboralMonto/editar""")
)
                      

// @LINE:1000
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesMontosController.index(), HandlerDef(this, "controllers.haberes.EscalasLaboralesMontosController", "index", Seq(), "GET", """""", _prefix + """haberes/escalaLaboralMonto""")
)
                      
    
}
                          

// @LINE:872
// @LINE:870
// @LINE:866
// @LINE:865
// @LINE:864
// @LINE:863
// @LINE:862
// @LINE:861
// @LINE:860
// @LINE:859
// @LINE:858
class ReverseLiquidacionPuestosController {
    

// @LINE:870
def cambiarEstado(idLiquidacionPuesto:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.cambiarEstado(idLiquidacionPuesto, idEstado), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/cambiarEstado""")
)
                      

// @LINE:859
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "crear", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/crear""")
)
                      

// @LINE:872
def preLiquidar(idPuestoLaboral:Long, idLiquidacionMes:Long, idLiquidacionPuesto:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.preLiquidar(idPuestoLaboral, idLiquidacionMes, idLiquidacionPuesto), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "preLiquidar", Seq(classOf[Long], classOf[Long], classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/preliquidar""")
)
                      

// @LINE:865
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/liquidacionPuesto/get""")
)
                      

// @LINE:866
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/ver""")
)
                      

// @LINE:862
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/eliminar""")
)
                      

// @LINE:860
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/guardar""")
)
                      

// @LINE:863
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/actualizar""")
)
                      

// @LINE:864
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/modalBuscar""")
)
                      

// @LINE:861
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/editar""")
)
                      

// @LINE:858
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosController.index(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosController", "index", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto""")
)
                      
    
}
                          

// @LINE:944
// @LINE:943
// @LINE:942
// @LINE:941
// @LINE:940
// @LINE:939
// @LINE:938
// @LINE:937
// @LINE:936
class ReverseLegajosController {
    

// @LINE:937
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.crear(), HandlerDef(this, "controllers.haberes.LegajosController", "crear", Seq(), "GET", """""", _prefix + """haberes/legajo/crear""")
)
                      

// @LINE:943
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.get(id), HandlerDef(this, "controllers.haberes.LegajosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/legajo/get""")
)
                      

// @LINE:944
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.ver(id), HandlerDef(this, "controllers.haberes.LegajosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/legajo/ver""")
)
                      

// @LINE:940
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.eliminar(id), HandlerDef(this, "controllers.haberes.LegajosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/legajo/eliminar""")
)
                      

// @LINE:938
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.guardar(), HandlerDef(this, "controllers.haberes.LegajosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/legajo/guardar""")
)
                      

// @LINE:941
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.actualizar(), HandlerDef(this, "controllers.haberes.LegajosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/legajo/actualizar""")
)
                      

// @LINE:942
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LegajosController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/legajo/modalBuscar""")
)
                      

// @LINE:939
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.editar(id), HandlerDef(this, "controllers.haberes.LegajosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/legajo/editar""")
)
                      

// @LINE:936
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LegajosController.index(), HandlerDef(this, "controllers.haberes.LegajosController", "index", Seq(), "GET", """""", _prefix + """haberes/legajo""")
)
                      
    
}
                          

// @LINE:825
// @LINE:824
// @LINE:823
// @LINE:822
// @LINE:821
// @LINE:820
// @LINE:819
// @LINE:818
// @LINE:817
class ReverseLiquidacionBaseCalculosController {
    

// @LINE:818
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "crear", Seq(), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo/crear""")
)
                      

// @LINE:824
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo/get""")
)
                      

// @LINE:825
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo/ver""")
)
                      

// @LINE:821
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo/eliminar""")
)
                      

// @LINE:819
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacionBaseCalculo/guardar""")
)
                      

// @LINE:822
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacionBaseCalculo/actualizar""")
)
                      

// @LINE:823
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo/modalBuscar""")
)
                      

// @LINE:820
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo/editar""")
)
                      

// @LINE:817
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionBaseCalculosController.index(), HandlerDef(this, "controllers.haberes.LiquidacionBaseCalculosController", "index", Seq(), "GET", """""", _prefix + """haberes/liquidacionBaseCalculo""")
)
                      
    
}
                          

// @LINE:934
// @LINE:933
// @LINE:932
// @LINE:931
// @LINE:930
// @LINE:929
// @LINE:928
// @LINE:927
// @LINE:926
class ReverseConveniosBancosController {
    

// @LINE:927
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.crear(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "crear", Seq(), "GET", """""", _prefix + """haberes/convenioBanco/crear""")
)
                      

// @LINE:933
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.get(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/convenioBanco/get""")
)
                      

// @LINE:934
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.ver(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/convenioBanco/ver""")
)
                      

// @LINE:930
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.eliminar(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/convenioBanco/eliminar""")
)
                      

// @LINE:928
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.guardar(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/convenioBanco/guardar""")
)
                      

// @LINE:931
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.actualizar(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/convenioBanco/actualizar""")
)
                      

// @LINE:932
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.modalBuscar(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/convenioBanco/modalBuscar""")
)
                      

// @LINE:929
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.editar(id), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/convenioBanco/editar""")
)
                      

// @LINE:926
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.ConveniosBancosController.index(), HandlerDef(this, "controllers.haberes.ConveniosBancosController", "index", Seq(), "GET", """""", _prefix + """haberes/convenioBanco""")
)
                      
    
}
                          

// @LINE:1046
// @LINE:805
// @LINE:804
// @LINE:803
// @LINE:802
// @LINE:801
// @LINE:800
// @LINE:799
// @LINE:798
// @LINE:797
class ReverseLiquidacionConceptosController {
    

// @LINE:798
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "crear", Seq(), "GET", """""", _prefix + """haberes/liquidacionConcepto/crear""")
)
                      

// @LINE:804
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/liquidacionConcepto/get""")
)
                      

// @LINE:805
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionConcepto/ver""")
)
                      

// @LINE:801
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionConcepto/eliminar""")
)
                      

// @LINE:799
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacionConcepto/guardar""")
)
                      

// @LINE:802
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacionConcepto/actualizar""")
)
                      

// @LINE:803
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/liquidacionConcepto/modalBuscar""")
)
                      

// @LINE:1046
def suggestLiquidacionConceptoTipo(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.suggestLiquidacionConceptoTipo(input), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "suggestLiquidacionConceptoTipo", Seq(classOf[String]), "GET", """""", _prefix + """suggestConcepto/$input<[^/]+>""")
)
                      

// @LINE:800
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionConcepto/editar""")
)
                      

// @LINE:797
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptosController.index(), HandlerDef(this, "controllers.haberes.LiquidacionConceptosController", "index", Seq(), "GET", """""", _prefix + """haberes/liquidacionConcepto""")
)
                      
    
}
                          

// @LINE:886
// @LINE:885
// @LINE:884
// @LINE:883
// @LINE:882
// @LINE:881
// @LINE:880
// @LINE:879
// @LINE:878
// @LINE:877
class ReverseLiquidacionPuestosAccionesController {
    

// @LINE:883
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/modalPasarBorrador""")
)
                      

// @LINE:881
def modalPasarPreaprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.modalPasarPreaprobado(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarPreaprobado", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/modalPasarPreaprobado""")
)
                      

// @LINE:877
def modalPasarAOtraLiquidacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAOtraLiquidacion(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarAOtraLiquidacion", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/modalPasarAOtraLiquidacion""")
)
                      

// @LINE:882
def pasarPreaprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.pasarPreaprobadoMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarPreaprobadoMasivo", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/pasarPreaprobadoMasivo""")
)
                      

// @LINE:879
def modalPasarAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.modalPasarAprobado(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarAprobado", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/modalPasarAprobado""")
)
                      

// @LINE:886
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/pasarCanceladoMasivo""")
)
                      

// @LINE:884
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/pasarBorradorMasivo""")
)
                      

// @LINE:885
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """haberes/liquidacionPuesto/modalPasarCancelado""")
)
                      

// @LINE:880
def pasarAprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarAprobadoMasivo", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/pasarEnCursoMasivo""")
)
                      

// @LINE:878
def pasarAOtraLiquidacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosAccionesController.pasarAOtraLiquidacion(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosAccionesController", "pasarAOtraLiquidacion", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/pasarAOtraLiquidacion""")
)
                      
    
}
                          

// @LINE:835
// @LINE:834
// @LINE:833
// @LINE:832
// @LINE:831
// @LINE:830
// @LINE:829
// @LINE:828
// @LINE:827
class ReverseLiquidacionTiposController {
    

// @LINE:828
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "crear", Seq(), "GET", """""", _prefix + """haberes/liquidacionTipo/crear""")
)
                      

// @LINE:834
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/liquidacionTipo/get""")
)
                      

// @LINE:835
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionTipo/ver""")
)
                      

// @LINE:831
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionTipo/eliminar""")
)
                      

// @LINE:829
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacionTipo/guardar""")
)
                      

// @LINE:832
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacionTipo/actualizar""")
)
                      

// @LINE:833
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/liquidacionTipo/modalBuscar""")
)
                      

// @LINE:830
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionTipo/editar""")
)
                      

// @LINE:827
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionTiposController.index(), HandlerDef(this, "controllers.haberes.LiquidacionTiposController", "index", Seq(), "GET", """""", _prefix + """haberes/liquidacionTipo""")
)
                      
    
}
                          

// @LINE:750
// @LINE:749
// @LINE:748
// @LINE:747
// @LINE:746
// @LINE:745
// @LINE:744
// @LINE:743
class ReverseNovedadesController {
    

// @LINE:746
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.crear(), HandlerDef(this, "controllers.haberes.NovedadesController", "crear", Seq(), "GET", """""", _prefix + """haberes/novedades/crear""")
)
                      

// @LINE:745
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.ver(id), HandlerDef(this, "controllers.haberes.NovedadesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/novedades/ver""")
)
                      

// @LINE:750
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.eliminar(id), HandlerDef(this, "controllers.haberes.NovedadesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/novedades/eliminar""")
)
                      

// @LINE:747
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.guardar(), HandlerDef(this, "controllers.haberes.NovedadesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/novedades/guardar""")
)
                      

// @LINE:749
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.actualizar(), HandlerDef(this, "controllers.haberes.NovedadesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/novedades/actualizar""")
)
                      

// @LINE:744
def lista(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.lista(), HandlerDef(this, "controllers.haberes.NovedadesController", "lista", Seq(), "GET", """""", _prefix + """haberes/novedades/lista""")
)
                      

// @LINE:748
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.editar(id), HandlerDef(this, "controllers.haberes.NovedadesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/novedades/editar""")
)
                      

// @LINE:743
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesController.index(), HandlerDef(this, "controllers.haberes.NovedadesController", "index", Seq(), "GET", """""", _prefix + """haberes/novedades""")
)
                      
    
}
                          

// @LINE:903
// @LINE:902
// @LINE:901
// @LINE:900
// @LINE:899
// @LINE:898
// @LINE:897
// @LINE:896
// @LINE:895
class ReverseCargosLaboralesController {
    

// @LINE:896
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.crear(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "crear", Seq(), "GET", """""", _prefix + """haberes/cargoLaboral/crear""")
)
                      

// @LINE:902
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.get(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/cargoLaboral/get""")
)
                      

// @LINE:903
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/cargoLaboral/ver""")
)
                      

// @LINE:899
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/cargoLaboral/eliminar""")
)
                      

// @LINE:897
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/cargoLaboral/guardar""")
)
                      

// @LINE:900
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/cargoLaboral/actualizar""")
)
                      

// @LINE:901
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/cargoLaboral/modalBuscar""")
)
                      

// @LINE:898
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/cargoLaboral/editar""")
)
                      

// @LINE:895
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CargosLaboralesController.index(), HandlerDef(this, "controllers.haberes.CargosLaboralesController", "index", Seq(), "GET", """""", _prefix + """haberes/cargoLaboral""")
)
                      
    
}
                          

// @LINE:753
// @LINE:752
class ReverseNovedadesAccionesController {
    

// @LINE:752
def crearMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesAccionesController.crearMasivo(), HandlerDef(this, "controllers.haberes.NovedadesAccionesController", "crearMasivo", Seq(), "GET", """""", _prefix + """haberes/novedades/acciones/crear-masivo""")
)
                      

// @LINE:753
def procesarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.NovedadesAccionesController.procesarMasivo(), HandlerDef(this, "controllers.haberes.NovedadesAccionesController", "procesarMasivo", Seq(), "POST", """""", _prefix + """haberes/novedades/acciones/procesar-masivo""")
)
                      
    
}
                          

// @LINE:845
// @LINE:844
// @LINE:843
// @LINE:842
// @LINE:841
// @LINE:840
// @LINE:839
// @LINE:838
// @LINE:837
class ReverseUnidadesLaboralesController {
    

// @LINE:838
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.crear(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "crear", Seq(), "GET", """""", _prefix + """haberes/unidadLaboral/crear""")
)
                      

// @LINE:844
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.get(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/unidadLaboral/get""")
)
                      

// @LINE:845
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/unidadLaboral/ver""")
)
                      

// @LINE:841
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/unidadLaboral/eliminar""")
)
                      

// @LINE:839
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/unidadLaboral/guardar""")
)
                      

// @LINE:842
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/unidadLaboral/actualizar""")
)
                      

// @LINE:843
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/unidadLaboral/modalBuscar""")
)
                      

// @LINE:840
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/unidadLaboral/editar""")
)
                      

// @LINE:837
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.UnidadesLaboralesController.index(), HandlerDef(this, "controllers.haberes.UnidadesLaboralesController", "index", Seq(), "GET", """""", _prefix + """haberes/unidadLaboral""")
)
                      
    
}
                          

// @LINE:997
// @LINE:996
// @LINE:995
// @LINE:994
// @LINE:993
// @LINE:992
// @LINE:991
// @LINE:990
class ReverseLiquidacionAccionesController {
    

// @LINE:992
def exportBanco(liquidacionId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.exportBanco(liquidacionId), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportBanco", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionAcciones/exportBanco""")
)
                      

// @LINE:995
def descargarAfip(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.descargarAfip(url), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "descargarAfip", Seq(classOf[String]), "GET", """""", _prefix + """haberes/liquidacionAcciones/descargarAfip""")
)
                      

// @LINE:997
def descargarIps(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.descargarIps(url), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "descargarIps", Seq(classOf[String]), "GET", """""", _prefix + """haberes/liquidacionAcciones/descargarIps""")
)
                      

// @LINE:991
def exportMacroSueldos(liquidacionId:Long, nuevo:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.exportMacroSueldos(liquidacionId, nuevo), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportMacroSueldos", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """haberes/liquidacionAcciones/exportMacroSueldos""")
)
                      

// @LINE:996
def exportIps(liquidacionId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.exportIps(liquidacionId), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportIps", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionAcciones/exportIps""")
)
                      

// @LINE:993
def descargarBanco(url:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.descargarBanco(url), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "descargarBanco", Seq(classOf[String]), "GET", """""", _prefix + """haberes/liquidacionAcciones/descargarBanco""")
)
                      

// @LINE:990
def exportMacroSueldosLista(nuevo:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.exportMacroSueldosLista(nuevo), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportMacroSueldosLista", Seq(classOf[Boolean]), "POST", """""", _prefix + """haberes/liquidacionAcciones/exportMacroSueldosLista""")
)
                      

// @LINE:994
def exportAfip(liquidacionId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionAccionesController.exportAfip(liquidacionId), HandlerDef(this, "controllers.haberes.LiquidacionAccionesController", "exportAfip", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionAcciones/exportAfip""")
)
                      
    
}
                          

// @LINE:1018
// @LINE:984
// @LINE:967
// @LINE:966
// @LINE:965
// @LINE:964
// @LINE:963
// @LINE:962
// @LINE:961
// @LINE:960
// @LINE:957
// @LINE:956
class ReverseLiquidacionMesesController {
    

// @LINE:984
def cambiarEstado(idLiquidacion:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.cambiarEstado(idLiquidacion, idEstado), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/cambiarEstado""")
)
                      

// @LINE:957
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "crear", Seq(), "GET", """""", _prefix + """haberes/liquidacionMes/crear""")
)
                      

// @LINE:965
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/liquidacionMes/get""")
)
                      

// @LINE:967
def preliquidar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.preliquidar(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "preliquidar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/preliquidar""")
)
                      

// @LINE:966
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/ver""")
)
                      

// @LINE:962
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/eliminar""")
)
                      

// @LINE:960
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacionMes/guardar""")
)
                      

// @LINE:963
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacionMes/actualizar""")
)
                      

// @LINE:964
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/liquidacionMes/modalBuscar""")
)
                      

// @LINE:1018
def suggestLiquidacionMes(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.suggestLiquidacionMes(input), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "suggestLiquidacionMes", Seq(classOf[String]), "GET", """""", _prefix + """suggestLiquidacionMes/$input<[^/]+>""")
)
                      

// @LINE:961
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/editar""")
)
                      

// @LINE:956
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesController.index(), HandlerDef(this, "controllers.haberes.LiquidacionMesesController", "index", Seq(), "GET", """""", _prefix + """haberes/liquidacionMes""")
)
                      
    
}
                          

// @LINE:1012
class ReversePrestaFacilController {
    

// @LINE:1012
def enviarArchivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PrestaFacilController.enviarArchivo(), HandlerDef(this, "controllers.haberes.PrestaFacilController", "enviarArchivo", Seq(), "GET", """""", _prefix + """haberes/prestaFacil/enviarArchivo""")
)
                      
    
}
                          

// @LINE:815
// @LINE:814
// @LINE:813
// @LINE:812
// @LINE:811
// @LINE:810
// @LINE:809
// @LINE:808
// @LINE:807
class ReverseLiquidacionConceptoTiposController {
    

// @LINE:808
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.crear(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "crear", Seq(), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo/crear""")
)
                      

// @LINE:814
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.get(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo/get""")
)
                      

// @LINE:815
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.ver(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo/ver""")
)
                      

// @LINE:811
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo/eliminar""")
)
                      

// @LINE:809
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacionConceptoTipo/guardar""")
)
                      

// @LINE:812
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacionConceptoTipo/actualizar""")
)
                      

// @LINE:813
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.modalBuscar(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo/modalBuscar""")
)
                      

// @LINE:810
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo/editar""")
)
                      

// @LINE:807
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionConceptoTiposController.index(), HandlerDef(this, "controllers.haberes.LiquidacionConceptoTiposController", "index", Seq(), "GET", """""", _prefix + """haberes/liquidacionConceptoTipo""")
)
                      
    
}
                          

// @LINE:913
// @LINE:912
// @LINE:911
// @LINE:910
// @LINE:909
// @LINE:908
// @LINE:907
// @LINE:906
// @LINE:905
class ReverseCentrosCostosController {
    

// @LINE:906
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.crear(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "crear", Seq(), "GET", """""", _prefix + """haberes/centroCosto/crear""")
)
                      

// @LINE:912
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.get(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/centroCosto/get""")
)
                      

// @LINE:913
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.ver(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/centroCosto/ver""")
)
                      

// @LINE:909
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.eliminar(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/centroCosto/eliminar""")
)
                      

// @LINE:907
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.guardar(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "guardar", Seq(), "POST", """""", _prefix + """haberes/centroCosto/guardar""")
)
                      

// @LINE:910
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.actualizar(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/centroCosto/actualizar""")
)
                      

// @LINE:911
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.modalBuscar(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/centroCosto/modalBuscar""")
)
                      

// @LINE:908
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.editar(id), HandlerDef(this, "controllers.haberes.CentrosCostosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/centroCosto/editar""")
)
                      

// @LINE:905
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.CentrosCostosController.index(), HandlerDef(this, "controllers.haberes.CentrosCostosController", "index", Seq(), "GET", """""", _prefix + """haberes/centroCosto""")
)
                      
    
}
                          

// @LINE:1048
// @LINE:1047
// @LINE:778
// @LINE:766
// @LINE:765
// @LINE:764
// @LINE:763
// @LINE:762
// @LINE:761
// @LINE:760
// @LINE:759
// @LINE:758
// @LINE:757
// @LINE:756
class ReversePuestosLaboralesController {
    

// @LINE:766
def cambiarEstado(idPuesto:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.cambiarEstado(idPuesto, idEstado), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """haberes/puestos-laborales/cambiarEstado""")
)
                      

// @LINE:1048
def suggestPuestoLaboralTodos(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.suggestPuestoLaboralTodos(input), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "suggestPuestoLaboralTodos", Seq(classOf[String]), "GET", """""", _prefix + """suggestPuestoLaboralTodos/$input<[^/]+>""")
)
                      

// @LINE:757
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.crear(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "crear", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/crear""")
)
                      

// @LINE:764
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.get(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/puestos-laborales/get""")
)
                      

// @LINE:763
def modalBuscarTodos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.modalBuscarTodos(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "modalBuscarTodos", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/modal-buscar-todos""")
)
                      

// @LINE:765
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/puestos-laborales/ver""")
)
                      

// @LINE:760
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/puestos-laborale/eliminar""")
)
                      

// @LINE:758
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/guardar""")
)
                      

// @LINE:761
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/actualizar""")
)
                      

// @LINE:1047
def suggestPuestoLaboral(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.suggestPuestoLaboral(input), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "suggestPuestoLaboral", Seq(classOf[String]), "GET", """""", _prefix + """suggestPuestoLaboral/$input<[^/]+>""")
)
                      

// @LINE:762
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/modal-buscar""")
)
                      

// @LINE:778
def liquidarCierre(idPuestoLaboral:Long, idLiquidacionMes:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.liquidarCierre(idPuestoLaboral, idLiquidacionMes), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "liquidarCierre", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """haberes/puestos-laborales/liquidarCierre""")
)
                      

// @LINE:759
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/puestos-laborales/editar""")
)
                      

// @LINE:756
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesController.index(), HandlerDef(this, "controllers.haberes.PuestosLaboralesController", "index", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales""")
)
                      
    
}
                          

// @LINE:875
// @LINE:874
// @LINE:871
// @LINE:869
// @LINE:868
// @LINE:867
class ReverseLiquidacionPuestosReportesController {
    

// @LINE:875
def enviarReciboPorMail(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosReportesController.enviarReciboPorMail(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "enviarReciboPorMail", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/reportes/enviarReciboPorMail""")
)
                      

// @LINE:868
def reciboSueldo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosReportesController.reciboSueldo(), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "reciboSueldo", Seq(), "POST", """""", _prefix + """haberes/liquidacionPuesto/reportes/reciboSueldo""")
)
                      

// @LINE:874
def modalReciboSueldoPorPuestoMail(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosReportesController.modalReciboSueldoPorPuestoMail(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "modalReciboSueldoPorPuestoMail", Seq(classOf[Long]), "POST", """""", _prefix + """haberes/liquidacionPuesto/reportes/modalReciboSueldoPorPuestoMail""")
)
                      

// @LINE:867
def reciboSueldoPorPuesto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosReportesController.reciboSueldoPorPuesto(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "reciboSueldoPorPuesto", Seq(classOf[Long]), "POST", """""", _prefix + """haberes/liquidacionPuesto/reportes/reciboSueldoPorPuesto""")
)
                      

// @LINE:871
def libroSueldos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosReportesController.libroSueldos(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "libroSueldos", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/reportes/libroSueldos""")
)
                      

// @LINE:869
def reciboSueldosByLiquidacionMes(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionPuestosReportesController.reciboSueldosByLiquidacionMes(id), HandlerDef(this, "controllers.haberes.LiquidacionPuestosReportesController", "reciboSueldosByLiquidacionMes", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionPuesto/reportes/reciboSueldosByLiquidacionMes""")
)
                      
    
}
                          

// @LINE:924
// @LINE:923
// @LINE:922
// @LINE:921
// @LINE:920
// @LINE:919
// @LINE:918
// @LINE:917
// @LINE:916
// @LINE:915
class ReverseEscalasLaboralesController {
    

// @LINE:916
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.crear(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "crear", Seq(), "GET", """""", _prefix + """haberes/escalaLaboral/crear""")
)
                      

// @LINE:922
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.get(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """haberes/escalaLaboral/get""")
)
                      

// @LINE:923
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.ver(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/escalaLaboral/ver""")
)
                      

// @LINE:919
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.eliminar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/escalaLaboral/eliminar""")
)
                      

// @LINE:917
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.guardar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/escalaLaboral/guardar""")
)
                      

// @LINE:920
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.actualizar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/escalaLaboral/actualizar""")
)
                      

// @LINE:924
def suggestEscalaLaboral(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.suggestEscalaLaboral(input), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "suggestEscalaLaboral", Seq(classOf[String]), "GET", """""", _prefix + """haberes/escalaLaboral/suggestEscalaLaboral/$input<[^/]+>""")
)
                      

// @LINE:921
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.modalBuscar(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "modalBuscar", Seq(), "GET", """""", _prefix + """haberes/escalaLaboral/modalBuscar""")
)
                      

// @LINE:918
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.editar(id), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/escalaLaboral/editar""")
)
                      

// @LINE:915
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.EscalasLaboralesController.index(), HandlerDef(this, "controllers.haberes.EscalasLaboralesController", "index", Seq(), "GET", """""", _prefix + """haberes/escalaLaboral""")
)
                      
    
}
                          

// @LINE:1010
// @LINE:1009
// @LINE:1008
class ReverseGananciasAccionesController {
    

// @LINE:1010
def modalFormularioF649(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.GananciasAccionesController.modalFormularioF649(), HandlerDef(this, "controllers.haberes.GananciasAccionesController", "modalFormularioF649", Seq(), "POST", """""", _prefix + """haberes/gananciasAcciones/modalFormularioF649""")
)
                      

// @LINE:1008
def buscarDatosGananciasEnArchivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.GananciasAccionesController.buscarDatosGananciasEnArchivos(), HandlerDef(this, "controllers.haberes.GananciasAccionesController", "buscarDatosGananciasEnArchivos", Seq(), "POST", """""", _prefix + """haberes/gananciasAcciones/buscarDatosGananciasEnArchivos""")
)
                      

// @LINE:1009
def modalBuscarDatosGananciasEnArchivos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.GananciasAccionesController.modalBuscarDatosGananciasEnArchivos(), HandlerDef(this, "controllers.haberes.GananciasAccionesController", "modalBuscarDatosGananciasEnArchivos", Seq(), "GET", """""", _prefix + """haberes/gananciasAcciones/modalBuscarDatosGananciasEnArchivos""")
)
                      
    
}
                          

// @LINE:742
class ReverseIndexController {
    

// @LINE:742
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.IndexController.index(), HandlerDef(this, "controllers.haberes.IndexController", "index", Seq(), "GET", """-----------------------------MODULO HABERES ---------------------------------""", _prefix + """haberes""")
)
                      
    
}
                          

// @LINE:784
// @LINE:783
// @LINE:781
// @LINE:780
// @LINE:777
// @LINE:776
// @LINE:775
// @LINE:774
// @LINE:773
// @LINE:772
// @LINE:771
// @LINE:770
class ReversePuestosLaboralesAccionesController {
    

// @LINE:783
def modalPreliquidarFinalPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarFinalPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPreliquidarFinalPuesto", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/acciones/modalPreliquidarPuestoFinal""")
)
                      

// @LINE:773
def crearNovedadesBasicas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.crearNovedadesBasicas(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "crearNovedadesBasicas", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/crearNovedades""")
)
                      

// @LINE:771
def desactivar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.desactivar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "desactivar", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/acciones/desactivar""")
)
                      

// @LINE:777
def pasarAControlado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.pasarAControlado(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "pasarAControlado", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/pasarAControlado""")
)
                      

// @LINE:775
def pasarABorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.pasarABorrador(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "pasarABorrador", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/pasarABorrador""")
)
                      

// @LINE:780
def modalPreliquidarPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.modalPreliquidarPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPreliquidarPuesto", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/acciones/modalPreliquidarPuesto""")
)
                      

// @LINE:772
def modalCrearNovedades(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.modalCrearNovedades(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalCrearNovedades", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/acciones/modalCrearNovedades""")
)
                      

// @LINE:774
def modalPasarABorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.modalPasarABorrador(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPasarABorrador", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/modalPasarABorrador""")
)
                      

// @LINE:776
def modalPasarAControlado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.modalPasarAControlado(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "modalPasarAControlado", Seq(), "GET", """""", _prefix + """haberes/puestos-laborales/modalPasarAControlado""")
)
                      

// @LINE:770
def activar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.activar(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "activar", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/acciones/activar""")
)
                      

// @LINE:781
def preliquidarPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.preliquidarPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "preliquidarPuesto", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/preliquidarPuesto""")
)
                      

// @LINE:784
def preliquidarFinalPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.PuestosLaboralesAccionesController.preliquidarFinalPuesto(), HandlerDef(this, "controllers.haberes.PuestosLaboralesAccionesController", "preliquidarFinalPuesto", Seq(), "POST", """""", _prefix + """haberes/puestos-laborales/preliquidarPuestoFinal""")
)
                      
    
}
                          

// @LINE:998
// @LINE:988
// @LINE:987
// @LINE:986
// @LINE:985
// @LINE:983
// @LINE:982
// @LINE:981
// @LINE:980
// @LINE:979
// @LINE:978
// @LINE:977
// @LINE:976
// @LINE:975
// @LINE:974
// @LINE:973
// @LINE:972
// @LINE:971
// @LINE:970
// @LINE:969
// @LINE:968
class ReverseLiquidacionMesesReportesController {
    

// @LINE:968
def totalPorConceptos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.totalPorConceptos(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "totalPorConceptos", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/totalPorConceptos""")
)
                      

// @LINE:978
def listadoDePuestoLaboral(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoDePuestoLaboral", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoDePuestoLaboral""")
)
                      

// @LINE:973
def listadoObraSocial(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoObraSocial(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoObraSocial", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoObraSocial""")
)
                      

// @LINE:980
def listadoDePuestoLaboralComparativoPeriodo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoDePuestoLaboralComparativoPeriodo(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoDePuestoLaboralComparativoPeriodo", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoDePuestoLaboralComparativoPeriodo""")
)
                      

// @LINE:972
def listadoJubilacion(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoJubilacion(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoJubilacion", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoJubilacion""")
)
                      

// @LINE:974
def datosGenerales(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.datosGenerales(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "datosGenerales", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/datosGenerales""")
)
                      

// @LINE:988
def reportesControlDatosAfipGanancias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.reportesControlDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "reportesControlDatosAfipGanancias", Seq(), "POST", """""", _prefix + """haberes/liquidacionMes/reportes/reportesControlDatosAfipGanancias""")
)
                      

// @LINE:987
def modalControlDatosAfipGanancias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.modalControlDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "modalControlDatosAfipGanancias", Seq(), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/modalControlDatosAfipGanancias""")
)
                      

// @LINE:975
def ordenDePago(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.ordenDePago(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "ordenDePago", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/ordenDePago""")
)
                      

// @LINE:977
def listadoPorConceptosPorPuestoLaboral(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoPorConceptosPorPuestoLaboral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoPorConceptosPorPuestoLaboral", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoPorConceptosPorPuestoLaboral""")
)
                      

// @LINE:971
def listadoSeguroSepelio(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoSeguroSepelio(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoSeguroSepelio", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoSeguroSepelio""")
)
                      

// @LINE:969
def comparativoCertificacion(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.comparativoCertificacion(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "comparativoCertificacion", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/comparativoCertificacion""")
)
                      

// @LINE:998
def exportDatosPorConcepto(liquidacionId:Long, conceptoId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.exportDatosPorConcepto(liquidacionId, conceptoId), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "exportDatosPorConcepto", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionAcciones/exportDatosPorConcepto""")
)
                      

// @LINE:982
def modalDatosAfip(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.modalDatosAfip(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "modalDatosAfip", Seq(), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/modalDatosAfip""")
)
                      

// @LINE:983
def reportesDatosAfip(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfip(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "reportesDatosAfip", Seq(), "POST", """""", _prefix + """haberes/liquidacionMes/reportes/reportesDatosAfip""")
)
                      

// @LINE:986
def reportesDatosAfipGanancias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.reportesDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "reportesDatosAfipGanancias", Seq(), "POST", """""", _prefix + """haberes/liquidacionMes/reportes/reportesDatosAfipGanancias""")
)
                      

// @LINE:979
def listadoGeneral(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoGeneral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoGeneral", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoGeneral""")
)
                      

// @LINE:981
def listadoPorEscalaPorPuestoLaboral(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoPorEscalaPorPuestoLaboral(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoPorEscalaPorPuestoLaboral", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoPorEscalaPorPuestoLaboral""")
)
                      

// @LINE:985
def modalDatosAfipGanancias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.modalDatosAfipGanancias(), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "modalDatosAfipGanancias", Seq(), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/modalDatosAfipGanancias""")
)
                      

// @LINE:976
def controlDescuentosBasicos(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.controlDescuentosBasicos(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "controlDescuentosBasicos", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/controlDescuentosBasicos""")
)
                      

// @LINE:970
def listadoSeguroVida(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionMesesReportesController.listadoSeguroVida(id), HandlerDef(this, "controllers.haberes.LiquidacionMesesReportesController", "listadoSeguroVida", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacionMes/reportes/listadoSeguroVida""")
)
                      
    
}
                          

// @LINE:893
// @LINE:892
// @LINE:891
// @LINE:890
// @LINE:889
// @LINE:888
class ReverseLiquidacionDetallesController {
    

// @LINE:888
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionDetallesController.index(id, editable), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """haberes/liquidacion-detalle/index""")
)
                      

// @LINE:893
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionDetallesController.eliminar(id), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacion-detalle/eliminar""")
)
                      

// @LINE:891
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionDetallesController.guardar(), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "guardar", Seq(), "POST", """""", _prefix + """haberes/liquidacion-detalle/guardar""")
)
                      

// @LINE:892
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionDetallesController.actualizar(), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "actualizar", Seq(), "POST", """""", _prefix + """haberes/liquidacion-detalle/actualizar""")
)
                      

// @LINE:890
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionDetallesController.editar(id), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """haberes/liquidacion-d20301766700etalle/editar""")
)
                      

// @LINE:889
def crear(liquidacionPuestoId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.haberes.LiquidacionDetallesController.crear(liquidacionPuestoId), HandlerDef(this, "controllers.haberes.LiquidacionDetallesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """haberes/liquidacion-detalle/crear""")
)
                      
    
}
                          
}
        

// @LINE:734
// @LINE:733
package controllers.rendiciones.ref {


// @LINE:733
class ReverseIndexController {
    

// @LINE:733
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rendiciones.IndexController.index(), HandlerDef(this, "controllers.rendiciones.IndexController", "index", Seq(), "GET", """-----------------------------MODULO RENDICIONES ---------------------------------""", _prefix + """rendiciones""")
)
                      
    
}
                          

// @LINE:734
class ReverseRendicionesController {
    

// @LINE:734
def indexPagosRealizados(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rendiciones.RendicionesController.indexPagosRealizados(), HandlerDef(this, "controllers.rendiciones.RendicionesController", "indexPagosRealizados", Seq(), "GET", """""", _prefix + """rendiciones/pagos-realizados""")
)
                      
    
}
                          
}
        

// @LINE:1051
// @LINE:1044
// @LINE:1041
// @LINE:1040
// @LINE:1039
// @LINE:1037
// @LINE:1035
// @LINE:1034
// @LINE:1023
// @LINE:1021
// @LINE:1020
// @LINE:1019
// @LINE:425
// @LINE:424
// @LINE:423
// @LINE:421
// @LINE:420
// @LINE:419
// @LINE:418
// @LINE:417
// @LINE:416
// @LINE:414
// @LINE:413
// @LINE:412
// @LINE:411
// @LINE:410
// @LINE:409
// @LINE:407
// @LINE:406
// @LINE:405
// @LINE:404
// @LINE:403
// @LINE:402
// @LINE:401
// @LINE:400
// @LINE:388
// @LINE:387
// @LINE:386
// @LINE:385
// @LINE:384
// @LINE:383
// @LINE:382
// @LINE:381
// @LINE:380
// @LINE:379
// @LINE:378
// @LINE:376
// @LINE:374
// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
// @LINE:367
// @LINE:366
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:362
// @LINE:361
// @LINE:360
// @LINE:359
// @LINE:358
// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:354
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:349
// @LINE:348
// @LINE:347
// @LINE:344
// @LINE:343
// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:337
// @LINE:336
// @LINE:334
// @LINE:333
// @LINE:332
// @LINE:331
// @LINE:330
// @LINE:329
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:315
// @LINE:314
// @LINE:313
// @LINE:312
// @LINE:311
// @LINE:309
// @LINE:308
// @LINE:307
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:296
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:287
// @LINE:286
// @LINE:285
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:278
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
// @LINE:268
// @LINE:266
// @LINE:265
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:260
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:253
// @LINE:252
// @LINE:250
// @LINE:249
// @LINE:248
// @LINE:247
// @LINE:245
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:240
// @LINE:239
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
// @LINE:231
// @LINE:228
// @LINE:227
// @LINE:226
// @LINE:225
// @LINE:223
// @LINE:222
// @LINE:221
// @LINE:220
// @LINE:219
// @LINE:218
// @LINE:216
// @LINE:215
// @LINE:213
// @LINE:211
// @LINE:210
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:205
// @LINE:203
// @LINE:202
// @LINE:201
// @LINE:200
// @LINE:199
// @LINE:198
// @LINE:196
// @LINE:195
// @LINE:194
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
// @LINE:189
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
// @LINE:162
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
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:141
// @LINE:140
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
// @LINE:104
// @LINE:103
// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
// @LINE:92
// @LINE:91
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
package controllers.compras.ref {


// @LINE:374
// @LINE:373
// @LINE:372
// @LINE:371
// @LINE:370
// @LINE:369
class ReverseCertificacionesComprasLineasController {
    

// @LINE:369
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineasController.index(id, editable), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/certificacion-compra-linea/index""")
)
                      

// @LINE:374
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineasController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra-linea/eliminar""")
)
                      

// @LINE:372
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineasController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "guardar", Seq(), "POST", """""", _prefix + """compras/certificacion-compra-linea/guardar""")
)
                      

// @LINE:373
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineasController.actualizar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "actualizar", Seq(), "POST", """""", _prefix + """compras/certificacion-compra-linea/actualizar""")
)
                      

// @LINE:371
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineasController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra-linea/editar""")
)
                      

// @LINE:370
def crear(certificacionId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineasController.crear(certificacionId), HandlerDef(this, "controllers.compras.CertificacionesComprasLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/certificacion-compra-linea/crear""")
)
                      
    
}
                          

// @LINE:223
// @LINE:222
// @LINE:219
// @LINE:112
// @LINE:111
// @LINE:110
// @LINE:109
// @LINE:108
// @LINE:107
// @LINE:106
class ReverseOrdenesReportesController {
    

// @LINE:108
def exportacionDatosConLineas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.exportacionDatosConLineas(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "exportacionDatosConLineas", Seq(), "POST", """""", _prefix + """ordenCompra/reporte/exportacionDatosConLineas""")
)
                      

// @LINE:107
def exportacionDatos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.exportacionDatos(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "exportacionDatos", Seq(), "POST", """""", _prefix + """ordenCompra/reporte/exportacionDatos""")
)
                      

// @LINE:106
def cuadroComparativoPrecios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.cuadroComparativoPrecios(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "cuadroComparativoPrecios", Seq(), "POST", """""", _prefix + """ordenCompra/reporte/cuadroComparativoPrecios""")
)
                      

// @LINE:222
def listadoLineas(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.listadoLineas(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "listadoLineas", Seq(classOf[Long]), "GET", """""", _prefix + """orden/reporte/listadoLineas""")
)
                      

// @LINE:111
def reporteCertificacionPaciente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.reporteCertificacionPaciente(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "reporteCertificacionPaciente", Seq(classOf[Long]), "GET", """""", _prefix + """ordenCompra/reporte/reporteCertificacionPaciente""")
)
                      

// @LINE:109
def cuadroSugerenciaAdjudicación(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.cuadroSugerenciaAdjudicación(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "cuadroSugerenciaAdjudicación", Seq(), "POST", """""", _prefix + """ordenCompra/reporte/cuadroSugerenciaAdjudicacion""")
)
                      

// @LINE:110
def controlDolar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.controlDolar(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "controlDolar", Seq(), "POST", """""", _prefix + """ordenCompra/reporte/controlDolar""")
)
                      

// @LINE:223
def reporteImputacionDefinitiva(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.reporteImputacionDefinitiva(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "reporteImputacionDefinitiva", Seq(classOf[Long]), "GET", """""", _prefix + """compras/reporte/imputacionDefinitiva""")
)
                      

// @LINE:219
def reporteImputacionDefinitivaGlobal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.reporteImputacionDefinitivaGlobal(), HandlerDef(this, "controllers.compras.OrdenesReportesController", "reporteImputacionDefinitivaGlobal", Seq(), "POST", """""", _prefix + """compras/orden/reporte/imputacionDefinitiva""")
)
                      

// @LINE:112
def controlProfe(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesReportesController.controlProfe(id), HandlerDef(this, "controllers.compras.OrdenesReportesController", "controlProfe", Seq(classOf[Long]), "POST", """""", _prefix + """ordenCompra/reporte/controlProfe""")
)
                      
    
}
                          

// @LINE:250
// @LINE:249
// @LINE:231
// @LINE:228
// @LINE:227
// @LINE:226
// @LINE:225
// @LINE:221
// @LINE:220
// @LINE:218
class ReverseSolicitudesReportesController {
    

// @LINE:218
def reporteImputacionPreventivaLista(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.reporteImputacionPreventivaLista(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteImputacionPreventivaLista", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/imputacionPreventiva""")
)
                      

// @LINE:249
def reportePedidoAbastecimiento(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.reportePedidoAbastecimiento(id), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reportePedidoAbastecimiento", Seq(classOf[Long]), "GET", """""", _prefix + """compras/reporte/reportePedidoAbastecimiento""")
)
                      

// @LINE:228
def informeFarmaciaPorUsuario(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.informeFarmaciaPorUsuario(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "informeFarmaciaPorUsuario", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/informeFarmaciaPorUsuario""")
)
                      

// @LINE:221
def reporteLineasCotizacion(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.reporteLineasCotizacion(id), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteLineasCotizacion", Seq(classOf[Long]), "POST", """""", _prefix + """compras/solicitud/reporte/lineasCotizacion""")
)
                      

// @LINE:231
def informeFarmaciaPaciente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.informeFarmaciaPaciente(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "informeFarmaciaPaciente", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/informeFarmaciaPaciente""")
)
                      

// @LINE:220
def reporteCuadroSolicitud(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.reporteCuadroSolicitud(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteCuadroSolicitud", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/cuadroSolicitud""")
)
                      

// @LINE:226
def informeFarmacia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.informeFarmacia(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "informeFarmacia", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/informeFarmacia""")
)
                      

// @LINE:250
def reporteImputacionPreventiva(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.reporteImputacionPreventiva(id), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "reporteImputacionPreventiva", Seq(classOf[Long]), "GET", """""", _prefix + """compras/reporte/imputacionPreventiva""")
)
                      

// @LINE:227
def modalInformeFarmaciaPorUsuario(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.modalInformeFarmaciaPorUsuario(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "modalInformeFarmaciaPorUsuario", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/modalInformeFarmaciaPorUsuario""")
)
                      

// @LINE:225
def modalInformeFarmacia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesReportesController.modalInformeFarmacia(), HandlerDef(this, "controllers.compras.SolicitudesReportesController", "modalInformeFarmacia", Seq(), "POST", """""", _prefix + """compras/solicitud/reporte/modalInformeFarmacia""")
)
                      
    
}
                          

// @LINE:216
// @LINE:215
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
class ReverseCertificacionesController {
    

// @LINE:172
def cambiarEstado(idCertificacion:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.compras.CertificacionesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/certificacion/cambiarEstado""")
)
                      

// @LINE:165
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.crear(), HandlerDef(this, "controllers.compras.CertificacionesController", "crear", Seq(), "GET", """""", _prefix + """compras/certificacion/crear""")
)
                      

// @LINE:171
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.actualizar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """compras/certificacion/actualizar""")
)
                      

// @LINE:216
def procesarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.procesarMasivo(), HandlerDef(this, "controllers.compras.CertificacionesController", "procesarMasivo", Seq(), "POST", """""", _prefix + """compras/certificaciones/acciones/procesar-masivo""")
)
                      

// @LINE:169
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.ver(id), HandlerDef(this, "controllers.compras.CertificacionesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion/ver""")
)
                      

// @LINE:168
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion/eliminar""")
)
                      

// @LINE:166
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesController", "guardar", Seq(), "POST", """""", _prefix + """compras/certificacion/guardar""")
)
                      

// @LINE:173
def modalEditarCuentaAnalica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.CertificacionesController", "modalEditarCuentaAnalica", Seq(), "GET", """""", _prefix + """compras/certificacion/modalEditarCuentaAnalitica""")
)
                      

// @LINE:174
def editarCuentaAnalitica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.CertificacionesController", "editarCuentaAnalitica", Seq(), "POST", """""", _prefix + """compras/certificacion/editarCuentaAnalitica""")
)
                      

// @LINE:215
def crearMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.crearMasivo(), HandlerDef(this, "controllers.compras.CertificacionesController", "crearMasivo", Seq(), "GET", """""", _prefix + """compras/certificaciones/acciones/crear-masivo""")
)
                      

// @LINE:167
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion/editar""")
)
                      

// @LINE:164
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.index(), HandlerDef(this, "controllers.compras.CertificacionesController", "index", Seq(), "GET", """""", _prefix + """compras/certificacion""")
)
                      

// @LINE:170
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesController.duplicar(id), HandlerDef(this, "controllers.compras.CertificacionesController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion/duplicar""")
)
                      
    
}
                          

// @LINE:117
// @LINE:116
// @LINE:115
// @LINE:114
class ReverseOrdenesLineasAjustesController {
    

// @LINE:114
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesLineasAjustesController.index(id, editable), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/orden/linea-orden-ajuste/index""")
)
                      

// @LINE:116
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesLineasAjustesController.eliminar(id), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/linea-orden-ajuste/eliminar""")
)
                      

// @LINE:117
def crear(ordenId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesLineasAjustesController.crear(ordenId), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/orden/linea-orden-ajuste/crear""")
)
                      

// @LINE:115
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesLineasAjustesController.guardar(), HandlerDef(this, "controllers.compras.OrdenesLineasAjustesController", "guardar", Seq(), "POST", """""", _prefix + """compras/orden/linea-orden-ajuste/guardar""")
)
                      
    
}
                          

// @LINE:1037
// @LINE:266
// @LINE:264
// @LINE:263
// @LINE:262
// @LINE:261
// @LINE:260
// @LINE:259
// @LINE:258
// @LINE:257
// @LINE:256
// @LINE:255
// @LINE:253
// @LINE:252
class ReverseProveedoresController {
    

// @LINE:261
def guardarContacto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.guardarContacto(), HandlerDef(this, "controllers.compras.ProveedoresController", "guardarContacto", Seq(), "POST", """""", _prefix + """compras/proveedores/guardarContacto""")
)
                      

// @LINE:253
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.crear(), HandlerDef(this, "controllers.compras.ProveedoresController", "crear", Seq(), "GET", """""", _prefix + """compras/proveedores/crear""")
)
                      

// @LINE:264
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.get(id), HandlerDef(this, "controllers.compras.ProveedoresController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/proveedores/get""")
)
                      

// @LINE:257
def eliminarContacto(sid:Long, cId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.eliminarContacto(sid, cId), HandlerDef(this, "controllers.compras.ProveedoresController", "eliminarContacto", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/proveedores/eliminarContacto""")
)
                      

// @LINE:266
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.ver(id), HandlerDef(this, "controllers.compras.ProveedoresController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/proveedores/ver""")
)
                      

// @LINE:256
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.eliminar(id), HandlerDef(this, "controllers.compras.ProveedoresController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/proveedores/eliminar""")
)
                      

// @LINE:255
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.guardar(), HandlerDef(this, "controllers.compras.ProveedoresController", "guardar", Seq(), "POST", """""", _prefix + """compras/proveedores/guardar""")
)
                      

// @LINE:1037
def suggestProveedor(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.suggestProveedor(input), HandlerDef(this, "controllers.compras.ProveedoresController", "suggestProveedor", Seq(classOf[String]), "GET", """""", _prefix + """suggestProveedor/$input<[^/]+>""")
)
                      

// @LINE:262
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.actualizar(), HandlerDef(this, "controllers.compras.ProveedoresController", "actualizar", Seq(), "POST", """""", _prefix + """compras/proveedores/actualizar""")
)
                      

// @LINE:260
def actualizarContacto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.actualizarContacto(), HandlerDef(this, "controllers.compras.ProveedoresController", "actualizarContacto", Seq(), "POST", """""", _prefix + """compras/proveedores/actualizarContacto""")
)
                      

// @LINE:263
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.modalBuscar(), HandlerDef(this, "controllers.compras.ProveedoresController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/proveedores/modalBuscar""")
)
                      

// @LINE:259
def formularioContacto(proveedorId:Long, id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.formularioContacto(proveedorId, id), HandlerDef(this, "controllers.compras.ProveedoresController", "formularioContacto", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/proveedores/editarContacto""")
)
                      

// @LINE:258
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.editar(id), HandlerDef(this, "controllers.compras.ProveedoresController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/proveedores/editar""")
)
                      

// @LINE:252
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresController.index(), HandlerDef(this, "controllers.compras.ProveedoresController", "index", Seq(), "GET", """""", _prefix + """compras/proveedores""")
)
                      
    
}
                          

// @LINE:357
// @LINE:356
// @LINE:355
// @LINE:354
// @LINE:353
// @LINE:352
// @LINE:351
// @LINE:350
// @LINE:349
// @LINE:348
// @LINE:347
class ReverseCertificacionesComprasController {
    

// @LINE:355
def cambiarEstado(idCertificacion:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra/cambiarEstado""")
)
                      

// @LINE:348
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.crear(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "crear", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/crear""")
)
                      

// @LINE:354
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.actualizar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """compras/certificacion-compra/actualizar""")
)
                      

// @LINE:352
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.ver(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra/ver""")
)
                      

// @LINE:351
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra/eliminar""")
)
                      

// @LINE:349
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "guardar", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/guardar""")
)
                      

// @LINE:356
def modalEditarCuentaAnalica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "modalEditarCuentaAnalica", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/modalEditarCuentaAnalitica""")
)
                      

// @LINE:357
def editarCuentaAnalitica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "editarCuentaAnalitica", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/editarCuentaAnalitica""")
)
                      

// @LINE:350
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra/editar""")
)
                      

// @LINE:347
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.index(), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "index", Seq(), "GET", """""", _prefix + """compras/certificacion-compra""")
)
                      

// @LINE:353
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasController.duplicar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-compra/duplicar""")
)
                      
    
}
                          

// @LINE:125
// @LINE:124
// @LINE:123
// @LINE:122
// @LINE:121
// @LINE:120
// @LINE:119
class ReverseLineasSolicitudesController {
    

// @LINE:121
def editar(id:Long, idDeposito:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.editar(id, idDeposito), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "editar", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/linea-solicitud/editar""")
)
                      

// @LINE:120
def crear(solicitudId:String, idDeposito:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.crear(solicitudId, idDeposito), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "crear", Seq(classOf[String], classOf[Long]), "GET", """""", _prefix + """compras/linea-solicitud/crear""")
)
                      

// @LINE:119
def index(id:Long, editable:Boolean, btnEliminar:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.index(id, editable, btnEliminar), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "index", Seq(classOf[Long], classOf[Boolean], classOf[Long]), "GET", """""", _prefix + """compras/linea-solicitud/index""")
)
                      

// @LINE:124
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.eliminar(id), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-solicitud/eliminar""")
)
                      

// @LINE:122
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.guardar(), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "guardar", Seq(), "POST", """""", _prefix + """compras/linea-solicitud/guardar""")
)
                      

// @LINE:123
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.actualizar(), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "actualizar", Seq(), "POST", """""", _prefix + """compras/linea-solicitud/actualizar""")
)
                      

// @LINE:125
def eliminarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasSolicitudesController.eliminarMasivo(), HandlerDef(this, "controllers.compras.LineasSolicitudesController", "eliminarMasivo", Seq(), "POST", """""", _prefix + """compras/linea-solicitud/eliminarMasivo""")
)
                      
    
}
                          

// @LINE:1021
// @LINE:318
// @LINE:317
// @LINE:316
// @LINE:315
// @LINE:314
// @LINE:313
// @LINE:312
// @LINE:311
class ReverseTipoProductosController {
    

// @LINE:315
def eliminarTipoProducto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.eliminarTipoProducto(id), HandlerDef(this, "controllers.compras.TipoProductosController", "eliminarTipoProducto", Seq(classOf[Long]), "GET", """""", _prefix + """compras/tipo-producto/eliminar""")
)
                      

// @LINE:316
def actualizarTipoProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.actualizarTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "actualizarTipoProducto", Seq(), "POST", """""", _prefix + """compras/tipo-producto/actualizar""")
)
                      

// @LINE:314
def editarTipoProducto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.editarTipoProducto(id), HandlerDef(this, "controllers.compras.TipoProductosController", "editarTipoProducto", Seq(classOf[Long]), "GET", """""", _prefix + """compras/tipo-producto/editar""")
)
                      

// @LINE:313
def guardarTipoProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.guardarTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "guardarTipoProducto", Seq(), "POST", """""", _prefix + """compras/tipo-producto/guardar""")
)
                      

// @LINE:318
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.get(id), HandlerDef(this, "controllers.compras.TipoProductosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/tipo-producto/get""")
)
                      

// @LINE:312
def crearTipoProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.crearTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "crearTipoProducto", Seq(), "GET", """""", _prefix + """compras/tipo-producto/crear""")
)
                      

// @LINE:317
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.modalBuscar(), HandlerDef(this, "controllers.compras.TipoProductosController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/tipo-producto/modalBuscar""")
)
                      

// @LINE:311
def indexTipoProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.indexTipoProducto(), HandlerDef(this, "controllers.compras.TipoProductosController", "indexTipoProducto", Seq(), "GET", """""", _prefix + """compras/tipo-producto""")
)
                      

// @LINE:1021
def suggestTipoProducto(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.TipoProductosController.suggestTipoProducto(input), HandlerDef(this, "controllers.compras.TipoProductosController", "suggestTipoProducto", Seq(classOf[String]), "GET", """""", _prefix + """suggestTipoProducto/$input<[^/]+>""")
)
                      
    
}
                          

// @LINE:248
// @LINE:247
// @LINE:162
// @LINE:161
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
// @LINE:141
// @LINE:140
class ReverseOrdenesAccionesController {
    

// @LINE:156
def modalEditarRubro(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalEditarRubro(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarRubro", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/modalEditarRubro""")
)
                      

// @LINE:151
def editarMontoAdelanto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.editarMontoAdelanto(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarMontoAdelanto", Seq(), "GET", """""", _prefix + """compras/orden/editarMontoAdelanto""")
)
                      

// @LINE:248
def generarOrdenSegunCuadroSugerenia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.generarOrdenSegunCuadroSugerenia(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "generarOrdenSegunCuadroSugerenia", Seq(), "POST", """""", _prefix + """compras/acciones/generarOrdenSegunCuadroSugerenia""")
)
                      

// @LINE:141
def importarListaProductos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.importarListaProductos(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "importarListaProductos", Seq(), "POST", """""", _prefix + """compras/orden/importarListaProductos""")
)
                      

// @LINE:155
def editarFechaProvision(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.editarFechaProvision(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarFechaProvision", Seq(), "GET", """""", _prefix + """compras/orden/editarFechaProvision""")
)
                      

// @LINE:158
def modalOrdenMail(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalOrdenMail(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalOrdenMail", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/modalOrdenMail""")
)
                      

// @LINE:247
def combinar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.combinar(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "combinar", Seq(), "POST", """""", _prefix + """compras/acciones/combinar""")
)
                      

// @LINE:150
def modalEditarMontoAdelanto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalEditarMontoAdelanto(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarMontoAdelanto", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/modalEditarMontoAdelanto""")
)
                      

// @LINE:157
def editarRubro(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.editarRubro(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarRubro", Seq(), "GET", """""", _prefix + """compras/orden/editarRubro""")
)
                      

// @LINE:161
def modalCrearDispo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalCrearDispo(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalCrearDispo", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/modalCrearDispo""")
)
                      

// @LINE:140
def modalImportarListaProductos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalImportarListaProductos(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalImportarListaProductos", Seq(), "POST", """""", _prefix + """compras/orden/modalImportarListaProductos""")
)
                      

// @LINE:162
def crearDispo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.crearDispo(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "crearDispo", Seq(), "GET", """""", _prefix + """compras/orden/crearDispo""")
)
                      

// @LINE:152
def modalEditarCotDolar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalEditarCotDolar(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarCotDolar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/modalEditarCotDolar""")
)
                      

// @LINE:154
def modalEditarFechaProvision(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.modalEditarFechaProvision(id), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "modalEditarFechaProvision", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/modalEditarFechaProvision""")
)
                      

// @LINE:159
def enviarOrdenMail(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.enviarOrdenMail(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "enviarOrdenMail", Seq(), "POST", """""", _prefix + """compras/orden/enviarOrdenMail""")
)
                      

// @LINE:153
def editarCotDolar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesAccionesController.editarCotDolar(), HandlerDef(this, "controllers.compras.OrdenesAccionesController", "editarCotDolar", Seq(), "GET", """""", _prefix + """compras/orden/editarCotDolar""")
)
                      
    
}
                          

// @LINE:1019
// @LINE:327
// @LINE:326
// @LINE:325
// @LINE:324
// @LINE:323
// @LINE:322
// @LINE:321
// @LINE:320
class ReverseArticulosController {
    

// @LINE:1019
def suggestArticulo(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.suggestArticulo(input), HandlerDef(this, "controllers.compras.ArticulosController", "suggestArticulo", Seq(classOf[String]), "GET", """""", _prefix + """suggestArticulo/$input<[^/]+>""")
)
                      

// @LINE:323
def editarArticulo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.editarArticulo(id), HandlerDef(this, "controllers.compras.ArticulosController", "editarArticulo", Seq(classOf[Long]), "GET", """""", _prefix + """compras/articulo/editar""")
)
                      

// @LINE:320
def indexArticulo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.indexArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "indexArticulo", Seq(), "GET", """""", _prefix + """compras/articulo""")
)
                      

// @LINE:327
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.get(id), HandlerDef(this, "controllers.compras.ArticulosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/articulo/get""")
)
                      

// @LINE:324
def eliminarArticulo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.eliminarArticulo(id), HandlerDef(this, "controllers.compras.ArticulosController", "eliminarArticulo", Seq(classOf[Long]), "GET", """""", _prefix + """compras/articulo/eliminar""")
)
                      

// @LINE:322
def guardarArticulo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.guardarArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "guardarArticulo", Seq(), "POST", """""", _prefix + """compras/articulo/guardar""")
)
                      

// @LINE:326
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.modalBuscar(), HandlerDef(this, "controllers.compras.ArticulosController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/articulo/modalBuscar""")
)
                      

// @LINE:325
def actualizarArticulo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.actualizarArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "actualizarArticulo", Seq(), "POST", """""", _prefix + """compras/articulo/actualizar""")
)
                      

// @LINE:321
def crearArticulo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ArticulosController.crearArticulo(), HandlerDef(this, "controllers.compras.ArticulosController", "crearArticulo", Seq(), "GET", """""", _prefix + """compras/articulo/crear""")
)
                      
    
}
                          

// @LINE:211
// @LINE:210
// @LINE:208
// @LINE:207
// @LINE:206
// @LINE:205
class ReverseCertificacionesComprasLineaAjustesController {
    

// @LINE:205
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineaAjustesController.index(id, editable), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/certificacion-linea-ajuste/index""")
)
                      

// @LINE:211
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineaAjustesController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-linea-ajuste/eliminar""")
)
                      

// @LINE:208
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineaAjustesController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "guardar", Seq(), "POST", """""", _prefix + """compras/certificacion-linea-ajuste/guardar""")
)
                      

// @LINE:210
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineaAjustesController.actualizar(), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "actualizar", Seq(), "POST", """""", _prefix + """compras/certificacion-linea-ajuste/actualizar""")
)
                      

// @LINE:207
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineaAjustesController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-linea-ajuste/editar""")
)
                      

// @LINE:206
def crear(certificacionId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasLineaAjustesController.crear(certificacionId), HandlerDef(this, "controllers.compras.CertificacionesComprasLineaAjustesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/certificacion-linea-ajuste/crear""")
)
                      
    
}
                          

// @LINE:131
// @LINE:130
// @LINE:129
// @LINE:128
class ReverseAjustesSolicitudesController {
    

// @LINE:128
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.AjustesSolicitudesController.index(id, editable), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/ajuste-solicitud/index""")
)
                      

// @LINE:131
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.AjustesSolicitudesController.eliminar(id), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/ajuste-solicitud/eliminar""")
)
                      

// @LINE:129
def crear(solicitudId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.AjustesSolicitudesController.crear(solicitudId), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/ajuste-solicitud/crear""")
)
                      

// @LINE:130
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.AjustesSolicitudesController.guardar(), HandlerDef(this, "controllers.compras.AjustesSolicitudesController", "guardar", Seq(), "POST", """""", _prefix + """compras/ajuste-solicitud/guardar""")
)
                      
    
}
                          

// @LINE:334
// @LINE:333
// @LINE:332
// @LINE:331
// @LINE:330
// @LINE:329
class ReverseProveedorAtributosController {
    

// @LINE:329
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorAtributosController.index(id, editable), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/linea-proveedor-atributo/index""")
)
                      

// @LINE:334
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorAtributosController.eliminar(id), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-proveedor-atributo/eliminar""")
)
                      

// @LINE:332
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorAtributosController.guardar(), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "guardar", Seq(), "POST", """""", _prefix + """compras/linea-proveedor-atributo/guardar""")
)
                      

// @LINE:333
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorAtributosController.actualizar(), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "actualizar", Seq(), "POST", """""", _prefix + """compras/linea-proveedor-atributo/actualizar""")
)
                      

// @LINE:331
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorAtributosController.editar(id), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-proveedor-atributo/editar""")
)
                      

// @LINE:330
def crear(proveedorId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorAtributosController.crear(proveedorId), HandlerDef(this, "controllers.compras.ProveedorAtributosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/linea-proveedor-atributo/crear""")
)
                      
    
}
                          

// @LINE:203
// @LINE:202
// @LINE:201
// @LINE:200
// @LINE:199
// @LINE:198
class ReverseLineasCertificacionesController {
    

// @LINE:198
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasCertificacionesController.index(id, editable), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/certificacion-linea/index""")
)
                      

// @LINE:203
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasCertificacionesController.eliminar(id), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-linea/eliminar""")
)
                      

// @LINE:201
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasCertificacionesController.guardar(), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "guardar", Seq(), "POST", """""", _prefix + """compras/certificacion-linea/guardar""")
)
                      

// @LINE:202
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasCertificacionesController.actualizar(), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "actualizar", Seq(), "POST", """""", _prefix + """compras/certificacion-linea/actualizar""")
)
                      

// @LINE:200
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasCertificacionesController.editar(id), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-linea/editar""")
)
                      

// @LINE:199
def crear(certificacionId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasCertificacionesController.crear(certificacionId), HandlerDef(this, "controllers.compras.LineasCertificacionesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/certificacion-linea/crear""")
)
                      
    
}
                          

// @LINE:160
class ReverseOrdenSubrubroController {
    

// @LINE:160
def listOptions(rubroId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenSubrubroController.listOptions(rubroId), HandlerDef(this, "controllers.compras.OrdenSubrubroController", "listOptions", Seq(classOf[Int]), "GET", """""", _prefix + """compras/ordenSubrubro/listOptions""")
)
                      
    
}
                          

// @LINE:414
// @LINE:413
// @LINE:412
// @LINE:411
// @LINE:410
// @LINE:409
// @LINE:407
// @LINE:406
// @LINE:405
// @LINE:404
// @LINE:403
// @LINE:402
// @LINE:401
// @LINE:400
class ReverseCajaChicaController {
    

// @LINE:407
def cambiarEstado(id:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.cambiarEstado(id, idEstado), HandlerDef(this, "controllers.compras.CajaChicaController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/cambiarEstado""")
)
                      

// @LINE:410
def reporteImputacionPreventivaLista(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.reporteImputacionPreventivaLista(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteImputacionPreventivaLista", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/reporteImputacionPreventivaLista""")
)
                      

// @LINE:402
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.crear(), HandlerDef(this, "controllers.compras.CajaChicaController", "crear", Seq(), "GET", """""", _prefix + """compras/caja-chica/crear""")
)
                      

// @LINE:405
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.actualizar(id), HandlerDef(this, "controllers.compras.CajaChicaController", "actualizar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/actualizar""")
)
                      

// @LINE:409
def resumenPresupuesto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.resumenPresupuesto(id), HandlerDef(this, "controllers.compras.CajaChicaController", "resumenPresupuesto", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/resumenPresupuesto""")
)
                      

// @LINE:401
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.ver(id), HandlerDef(this, "controllers.compras.CajaChicaController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/ver""")
)
                      

// @LINE:411
def reporteImputacionPreventivaAjustesLista(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.reporteImputacionPreventivaAjustesLista(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteImputacionPreventivaAjustesLista", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/reporteImputacionPreventivaListaAjuste""")
)
                      

// @LINE:406
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.eliminar(id), HandlerDef(this, "controllers.compras.CajaChicaController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/eliminar""")
)
                      

// @LINE:403
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.guardar(), HandlerDef(this, "controllers.compras.CajaChicaController", "guardar", Seq(), "GET", """""", _prefix + """compras/caja-chica/guardar""")
)
                      

// @LINE:413
def reporteCajaChica(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.reporteCajaChica(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteCajaChica", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/reporteCajaChica""")
)
                      

// @LINE:404
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.editar(id), HandlerDef(this, "controllers.compras.CajaChicaController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/editar""")
)
                      

// @LINE:400
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.index(), HandlerDef(this, "controllers.compras.CajaChicaController", "index", Seq(), "GET", """""", _prefix + """compras/caja-chica""")
)
                      

// @LINE:412
def reporteImputacionDefinitiva(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.reporteImputacionDefinitiva(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteImputacionDefinitiva", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/reporteImputacionDefinitiva""")
)
                      

// @LINE:414
def reporteCajaChicaOrdenCargo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaController.reporteCajaChicaOrdenCargo(id), HandlerDef(this, "controllers.compras.CajaChicaController", "reporteCajaChicaOrdenCargo", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica/reporteCajaChicaOrdenCargo""")
)
                      
    
}
                          

// @LINE:1039
// @LINE:283
// @LINE:282
// @LINE:281
// @LINE:280
// @LINE:279
// @LINE:278
// @LINE:277
// @LINE:276
// @LINE:275
// @LINE:274
// @LINE:273
// @LINE:272
// @LINE:271
// @LINE:270
class ReverseClientesController {
    

// @LINE:271
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.crear(), HandlerDef(this, "controllers.compras.ClientesController", "crear", Seq(), "GET", """""", _prefix + """compras/clientes/crear""")
)
                      

// @LINE:281
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.get(id), HandlerDef(this, "controllers.compras.ClientesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/get""")
)
                      

// @LINE:278
def eliminarContacto(sid:Long, cId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.eliminarContacto(sid, cId), HandlerDef(this, "controllers.compras.ClientesController", "eliminarContacto", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/clientes/eliminarContacto""")
)
                      

// @LINE:276
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.ver(id), HandlerDef(this, "controllers.compras.ClientesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/clientes/ver""")
)
                      

// @LINE:275
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.eliminar(id), HandlerDef(this, "controllers.compras.ClientesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/clientes/eliminar""")
)
                      

// @LINE:272
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.guardar(), HandlerDef(this, "controllers.compras.ClientesController", "guardar", Seq(), "POST", """""", _prefix + """compras/clientes/guardar""")
)
                      

// @LINE:274
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.actualizar(), HandlerDef(this, "controllers.compras.ClientesController", "actualizar", Seq(), "POST", """""", _prefix + """compras/clientes/actualizar""")
)
                      

// @LINE:280
def actualizarContacto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.actualizarContacto(), HandlerDef(this, "controllers.compras.ClientesController", "actualizarContacto", Seq(), "POST", """""", _prefix + """compras/clientes/actualizarContacto""")
)
                      

// @LINE:279
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.modalBuscar(), HandlerDef(this, "controllers.compras.ClientesController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/clientes/modalBuscar""")
)
                      

// @LINE:282
def modalCarga(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.modalCarga(), HandlerDef(this, "controllers.compras.ClientesController", "modalCarga", Seq(), "GET", """""", _prefix + """compras/modalCargar""")
)
                      

// @LINE:277
def formularioContacto(clienteId:Long, id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.formularioContacto(clienteId, id), HandlerDef(this, "controllers.compras.ClientesController", "formularioContacto", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/clientes/editarContacto""")
)
                      

// @LINE:1039
def suggestCliente(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.suggestCliente(input), HandlerDef(this, "controllers.compras.ClientesController", "suggestCliente", Seq(classOf[String]), "GET", """""", _prefix + """suggestCliente/$input<[^/]+>""")
)
                      

// @LINE:283
def guardarDesdeModal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.guardarDesdeModal(), HandlerDef(this, "controllers.compras.ClientesController", "guardarDesdeModal", Seq(), "POST", """""", _prefix + """compras/guardarDesdeModal""")
)
                      

// @LINE:273
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.editar(id), HandlerDef(this, "controllers.compras.ClientesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/clientes/editar""")
)
                      

// @LINE:270
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ClientesController.index(), HandlerDef(this, "controllers.compras.ClientesController", "index", Seq(), "GET", """""", _prefix + """compras/clientes""")
)
                      
    
}
                          

// @LINE:239
// @LINE:238
// @LINE:237
// @LINE:236
// @LINE:235
// @LINE:234
// @LINE:233
class ReversePedidosFondosController {
    

// @LINE:234
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.crear(), HandlerDef(this, "controllers.compras.PedidosFondosController", "crear", Seq(), "GET", """""", _prefix + """compras/pedidoFondo/crear""")
)
                      

// @LINE:239
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.actualizar(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "actualizar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/pedidoFondo/actualizar""")
)
                      

// @LINE:238
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.ver(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/pedidoFondo/ver""")
)
                      

// @LINE:237
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.eliminar(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/pedidoFondo/eliminar""")
)
                      

// @LINE:235
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.guardar(), HandlerDef(this, "controllers.compras.PedidosFondosController", "guardar", Seq(), "POST", """""", _prefix + """compras/pedidoFondo/guardar""")
)
                      

// @LINE:236
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.editar(id), HandlerDef(this, "controllers.compras.PedidosFondosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/pedidoFondo/editar""")
)
                      

// @LINE:233
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.PedidosFondosController.index(), HandlerDef(this, "controllers.compras.PedidosFondosController", "index", Seq(), "GET", """""", _prefix + """compras/pedidoFondo""")
)
                      
    
}
                          

// @LINE:196
// @LINE:195
// @LINE:193
// @LINE:192
// @LINE:191
// @LINE:190
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
class ReverseCertificacionesAccionesController {
    

// @LINE:178
def pasarCertificadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.pasarCertificadoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarCertificadoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/pasarCertificadoMasivo""")
)
                      

// @LINE:190
def modalDuplicarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalDuplicarMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalDuplicarMasivo", Seq(), "GET", """""", _prefix + """compras/certificacion/modalDuplicarMasivo""")
)
                      

// @LINE:195
def modalDetalleCertificacion(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalDetalleCertificacion(id), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalDetalleCertificacion", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion/modalDetalleCertificacion""")
)
                      

// @LINE:181
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """compras/certificacion/modalPasarBorrador""")
)
                      

// @LINE:193
def crearAguinaldo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.crearAguinaldo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "crearAguinaldo", Seq(), "POST", """""", _prefix + """compras/certificacion/CrearAguinaldo""")
)
                      

// @LINE:191
def duplicarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.duplicarMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "duplicarMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/duplicarMasivo""")
)
                      

// @LINE:179
def modalPasarAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalPasarAprobado(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarAprobado", Seq(), "GET", """""", _prefix + """compras/certificacion/modalPasarAprobado""")
)
                      

// @LINE:192
def modalCrearAguinaldo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalCrearAguinaldo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalCrearAguinaldo", Seq(), "GET", """""", _prefix + """compras/certificacion/modalCrearAguinaldo""")
)
                      

// @LINE:184
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/pasarCanceladoMasivo""")
)
                      

// @LINE:182
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/pasarBorradorMasivo""")
)
                      

// @LINE:185
def modalEditarFechaCertificacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalEditarFechaCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalEditarFechaCertificacion", Seq(), "GET", """""", _prefix + """compras/certificacion/modalEditarFechaCertificacion""")
)
                      

// @LINE:183
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """compras/certificacion/modalPasarCancelado""")
)
                      

// @LINE:180
def pasarAprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarAprobadoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/pasarAprobadoMasivo""")
)
                      

// @LINE:186
def editarFechaCertificacionMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.editarFechaCertificacionMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "editarFechaCertificacionMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/editarFechaCertificacionMasivo""")
)
                      

// @LINE:196
def modalDetalleCertificacionesPorEstadoPorPeriodo(nombrePeriodo:String, estado:Integer, proveedorId:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalDetalleCertificacionesPorEstadoPorPeriodo(nombrePeriodo, estado, proveedorId), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalDetalleCertificacionesPorEstadoPorPeriodo", Seq(classOf[String], classOf[Integer], classOf[Integer]), "GET", """""", _prefix + """compras/certificacion/modalDetalleCertificacionesPorEstadoPorPeriodo""")
)
                      

// @LINE:175
def modalPasarEnCurso(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalPasarEnCurso(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarEnCurso", Seq(), "GET", """""", _prefix + """compras/certificacion/modalPasarEnCurso""")
)
                      

// @LINE:177
def modalPasarCertificado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.modalPasarCertificado(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "modalPasarCertificado", Seq(), "GET", """""", _prefix + """compras/certificacion/modalPasarCertificado""")
)
                      

// @LINE:176
def pasarEnCursoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesAccionesController.pasarEnCursoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesAccionesController", "pasarEnCursoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion/pasarEnCursoMasivo""")
)
                      
    
}
                          

// @LINE:104
// @LINE:103
class ReverseOrdenesLineasClientesController {
    

// @LINE:103
def guardarAjax(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesLineasClientesController.guardarAjax(), HandlerDef(this, "controllers.compras.OrdenesLineasClientesController", "guardarAjax", Seq(), "POST", """""", _prefix + """compras/linea-orden-cliente/guardarAjax""")
)
                      

// @LINE:104
def eliminarAjax(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesLineasClientesController.eliminarAjax(id), HandlerDef(this, "controllers.compras.OrdenesLineasClientesController", "eliminarAjax", Seq(classOf[Long]), "POST", """""", _prefix + """compras/linea-orden-cliente/eliminarAjax""")
)
                      
    
}
                          

// @LINE:1051
// @LINE:344
// @LINE:343
class ReverseObrasSocialesController {
    

// @LINE:343
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ObrasSocialesController.modalBuscar(), HandlerDef(this, "controllers.compras.ObrasSocialesController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/ob/modalBuscar""")
)
                      

// @LINE:1051
def suggestObrasocial(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ObrasSocialesController.suggestObrasocial(input), HandlerDef(this, "controllers.compras.ObrasSocialesController", "suggestObrasocial", Seq(classOf[String]), "GET", """""", _prefix + """suggestOb/$input<[^/]+>""")
)
                      

// @LINE:344
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ObrasSocialesController.get(id), HandlerDef(this, "controllers.compras.ObrasSocialesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/ob/get""")
)
                      
    
}
                          

// @LINE:425
// @LINE:424
// @LINE:423
class ReverseCajaChicaPresupuestoLineasController {
    

// @LINE:424
def crear(cajaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaPresupuestoLineasController.crear(cajaId), HandlerDef(this, "controllers.compras.CajaChicaPresupuestoLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/caja-chica-presupuesto/crear""")
)
                      

// @LINE:423
def lista(cajaId:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaPresupuestoLineasController.lista(cajaId, editable), HandlerDef(this, "controllers.compras.CajaChicaPresupuestoLineasController", "lista", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/caja-chica-presupuesto""")
)
                      

// @LINE:425
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaPresupuestoLineasController.guardar(), HandlerDef(this, "controllers.compras.CajaChicaPresupuestoLineasController", "guardar", Seq(), "POST", """""", _prefix + """compras/caja-chica-presupuesto/guardar""")
)
                      
    
}
                          

// @LINE:341
// @LINE:340
// @LINE:339
// @LINE:338
// @LINE:337
// @LINE:336
class ReverseProveedorDatosDgrController {
    

// @LINE:337
def crear(cuit:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorDatosDgrController.crear(cuit), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "crear", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-proveedor-datodgr/crear""")
)
                      

// @LINE:336
def index(cuit:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorDatosDgrController.index(cuit, editable), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/linea-proveedor-datodgr/index""")
)
                      

// @LINE:341
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorDatosDgrController.eliminar(id), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-proveedor-datodgr/eliminar""")
)
                      

// @LINE:339
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorDatosDgrController.guardar(), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "guardar", Seq(), "POST", """""", _prefix + """compras/linea-proveedor-datodgr/guardar""")
)
                      

// @LINE:340
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorDatosDgrController.actualizar(), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "actualizar", Seq(), "POST", """""", _prefix + """compras/linea-proveedor-datodgr/actualizar""")
)
                      

// @LINE:338
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedorDatosDgrController.editar(id), HandlerDef(this, "controllers.compras.ProveedorDatosDgrController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-proveedor-datodgr/editar""")
)
                      
    
}
                          

// @LINE:101
// @LINE:100
// @LINE:99
// @LINE:98
// @LINE:97
// @LINE:96
// @LINE:95
// @LINE:94
class ReverseLineasOrdenesController {
    

// @LINE:94
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.index(id, editable), HandlerDef(this, "controllers.compras.LineasOrdenesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/linea-orden/index""")
)
                      

// @LINE:99
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.eliminar(id), HandlerDef(this, "controllers.compras.LineasOrdenesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-orden/eliminar""")
)
                      

// @LINE:97
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.guardar(), HandlerDef(this, "controllers.compras.LineasOrdenesController", "guardar", Seq(), "POST", """""", _prefix + """compras/linea-orden/guardar""")
)
                      

// @LINE:98
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.actualizar(), HandlerDef(this, "controllers.compras.LineasOrdenesController", "actualizar", Seq(), "POST", """""", _prefix + """compras/linea-orden/actualizar""")
)
                      

// @LINE:101
def eliminarMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.eliminarMasivo(), HandlerDef(this, "controllers.compras.LineasOrdenesController", "eliminarMasivo", Seq(), "POST", """""", _prefix + """compras/linea-orden/eliminar-masivo""")
)
                      

// @LINE:96
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.editar(id), HandlerDef(this, "controllers.compras.LineasOrdenesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-orden/editar""")
)
                      

// @LINE:95
def crear(ordenId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.crear(ordenId), HandlerDef(this, "controllers.compras.LineasOrdenesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/linea-orden/crear""")
)
                      

// @LINE:100
def modalAddClientes(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasOrdenesController.modalAddClientes(id), HandlerDef(this, "controllers.compras.LineasOrdenesController", "modalAddClientes", Seq(classOf[Long]), "GET", """""", _prefix + """compras/linea-orden/modalAddClientes""")
)
                      
    
}
                          

// @LINE:421
// @LINE:420
// @LINE:419
// @LINE:418
// @LINE:417
// @LINE:416
class ReverseCajaChicaMovimientosController {
    

// @LINE:421
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaMovimientosController.eliminar(id), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica-movimientos/eliminar""")
)
                      

// @LINE:419
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaMovimientosController.guardar(), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "guardar", Seq(), "POST", """""", _prefix + """compras/caja-chica-movimientos/guardar""")
)
                      

// @LINE:420
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaMovimientosController.actualizar(), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "actualizar", Seq(), "POST", """""", _prefix + """compras/caja-chica-movimientos/actualizar""")
)
                      

// @LINE:416
def lista(cajaId:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaMovimientosController.lista(cajaId, editable), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "lista", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/caja-chica-movimientos""")
)
                      

// @LINE:418
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaMovimientosController.editar(id), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/caja-chica-movimientos/editar""")
)
                      

// @LINE:417
def crear(cajaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CajaChicaMovimientosController.crear(cajaId), HandlerDef(this, "controllers.compras.CajaChicaMovimientosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/caja-chica-movimientos/crear""")
)
                      
    
}
                          

// @LINE:388
// @LINE:387
// @LINE:386
// @LINE:385
// @LINE:384
// @LINE:383
// @LINE:382
// @LINE:381
// @LINE:380
// @LINE:379
// @LINE:378
class ReverseCertificacionesObrasController {
    

// @LINE:386
def cambiarEstado(idCertificacion:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.cambiarEstado(idCertificacion, idEstado), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/certificacion-obra/cambiarEstado""")
)
                      

// @LINE:379
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.crear(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "crear", Seq(), "GET", """""", _prefix + """compras/certificacion-obra/crear""")
)
                      

// @LINE:385
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.actualizar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """compras/certificacion-obra/actualizar""")
)
                      

// @LINE:383
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.ver(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-obra/ver""")
)
                      

// @LINE:382
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.eliminar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-obra/eliminar""")
)
                      

// @LINE:380
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.guardar(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "guardar", Seq(), "POST", """""", _prefix + """compras/certificacion-obra/guardar""")
)
                      

// @LINE:387
def modalEditarCuentaAnalica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "modalEditarCuentaAnalica", Seq(), "GET", """""", _prefix + """compras/certificacion-obra/modalEditarCuentaAnalitica""")
)
                      

// @LINE:388
def editarCuentaAnalitica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "editarCuentaAnalitica", Seq(), "POST", """""", _prefix + """compras/certificacion-obra/editarCuentaAnalitica""")
)
                      

// @LINE:381
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.editar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-obra/editar""")
)
                      

// @LINE:378
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.index(), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "index", Seq(), "GET", """""", _prefix + """compras/certificacion-obra""")
)
                      

// @LINE:384
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesObrasController.duplicar(id), HandlerDef(this, "controllers.compras.CertificacionesObrasController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/certificacion-obra/duplicar""")
)
                      
    
}
                          

// @LINE:1020
// @LINE:309
// @LINE:308
// @LINE:307
// @LINE:306
// @LINE:305
// @LINE:304
// @LINE:303
// @LINE:302
class ReverseCategoriasController {
    

// @LINE:307
def actualizarCategoria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.actualizarCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "actualizarCategoria", Seq(), "POST", """""", _prefix + """compras/categorias/actualizar""")
)
                      

// @LINE:306
def eliminarCategoria(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.eliminarCategoria(id), HandlerDef(this, "controllers.compras.CategoriasController", "eliminarCategoria", Seq(classOf[Long]), "GET", """""", _prefix + """compras/categorias/eliminar""")
)
                      

// @LINE:305
def editarCategoria(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.editarCategoria(id), HandlerDef(this, "controllers.compras.CategoriasController", "editarCategoria", Seq(classOf[Long]), "GET", """""", _prefix + """compras/categorias/editar""")
)
                      

// @LINE:1020
def suggestCategoria(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.suggestCategoria(input), HandlerDef(this, "controllers.compras.CategoriasController", "suggestCategoria", Seq(classOf[String]), "GET", """""", _prefix + """suggestCategoria/$input<[^/]+>""")
)
                      

// @LINE:309
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.get(id), HandlerDef(this, "controllers.compras.CategoriasController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/categorias/get""")
)
                      

// @LINE:308
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.modalBuscar(), HandlerDef(this, "controllers.compras.CategoriasController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/categorias/modalBuscar""")
)
                      

// @LINE:302
def indexCategoria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.indexCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "indexCategoria", Seq(), "GET", """""", _prefix + """compras/categorias""")
)
                      

// @LINE:304
def guardarCategoria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.guardarCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "guardarCategoria", Seq(), "POST", """""", _prefix + """compras/categorias/guardar""")
)
                      

// @LINE:303
def crearCategoria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CategoriasController.crearCategoria(), HandlerDef(this, "controllers.compras.CategoriasController", "crearCategoria", Seq(), "GET", """""", _prefix + """compras/categorias/crear""")
)
                      
    
}
                          

// @LINE:245
// @LINE:244
// @LINE:243
// @LINE:242
// @LINE:241
// @LINE:240
class ReverseLineasPedidosFondosController {
    

// @LINE:240
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasPedidosFondosController.index(id, editable), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """compras/pedido-fondo-linea/index""")
)
                      

// @LINE:245
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasPedidosFondosController.eliminar(id), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/pedido-fondo-linea/eliminar""")
)
                      

// @LINE:243
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasPedidosFondosController.guardar(), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "guardar", Seq(), "POST", """""", _prefix + """compras/pedido-fondo-linea/guardar""")
)
                      

// @LINE:244
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasPedidosFondosController.actualizar(), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "actualizar", Seq(), "POST", """""", _prefix + """compras/pedido-fondo-linea/actualizar""")
)
                      

// @LINE:242
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasPedidosFondosController.editar(id), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/pedido-fondo-linea/editar""")
)
                      

// @LINE:241
def crear(pedidoFondoId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.LineasPedidosFondosController.crear(pedidoFondoId), HandlerDef(this, "controllers.compras.LineasPedidosFondosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """compras/pedido-fondo-linea/crear""")
)
                      
    
}
                          

// @LINE:65
class ReverseIndexController {
    

// @LINE:65
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.IndexController.index(), HandlerDef(this, "controllers.compras.IndexController", "index", Seq(), "GET", """-----------------------------MODULO COMPRAS ---------------------------------""", _prefix + """compras""")
)
                      
    
}
                          

// @LINE:1035
// @LINE:148
// @LINE:147
// @LINE:146
// @LINE:145
// @LINE:144
// @LINE:143
// @LINE:139
// @LINE:138
// @LINE:137
// @LINE:136
// @LINE:135
// @LINE:134
// @LINE:133
class ReverseOrdenesController {
    

// @LINE:146
def cambiarEstado(idOrden:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.cambiarEstado(idOrden, idEstado), HandlerDef(this, "controllers.compras.OrdenesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """compras/orden/cambiarEstado""")
)
                      

// @LINE:134
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.crear(), HandlerDef(this, "controllers.compras.OrdenesController", "crear", Seq(), "GET", """""", _prefix + """compras/orden/crear""")
)
                      

// @LINE:139
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.actualizar(id), HandlerDef(this, "controllers.compras.OrdenesController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """compras/orden/actualizar""")
)
                      

// @LINE:1035
def suggestOrden(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.suggestOrden(input), HandlerDef(this, "controllers.compras.OrdenesController", "suggestOrden", Seq(classOf[String]), "GET", """""", _prefix + """suggestOrden/$input<[^/]+>""")
)
                      

// @LINE:143
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.ver(id), HandlerDef(this, "controllers.compras.OrdenesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/ver""")
)
                      

// @LINE:137
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.eliminar(id), HandlerDef(this, "controllers.compras.OrdenesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/eliminar""")
)
                      

// @LINE:135
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.guardar(), HandlerDef(this, "controllers.compras.OrdenesController", "guardar", Seq(), "POST", """""", _prefix + """compras/orden/guardar""")
)
                      

// @LINE:148
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.get(id), HandlerDef(this, "controllers.compras.OrdenesController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/get""")
)
                      

// @LINE:147
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.modalBuscar(), HandlerDef(this, "controllers.compras.OrdenesController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/orden/modalBuscar""")
)
                      

// @LINE:144
def modalEditarCuentaAnalica(tipo:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.modalEditarCuentaAnalica(tipo), HandlerDef(this, "controllers.compras.OrdenesController", "modalEditarCuentaAnalica", Seq(classOf[String]), "GET", """""", _prefix + """compras/orden/modalEditarCuentaAnalitica""")
)
                      

// @LINE:145
def editarCuentaAnalitica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.OrdenesController", "editarCuentaAnalitica", Seq(), "POST", """""", _prefix + """compras/orden/editarCuentaAnalitica""")
)
                      

// @LINE:136
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.editar(id), HandlerDef(this, "controllers.compras.OrdenesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/editar""")
)
                      

// @LINE:133
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.index(), HandlerDef(this, "controllers.compras.OrdenesController", "index", Seq(), "GET", """""", _prefix + """compras/orden""")
)
                      

// @LINE:138
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.OrdenesController.duplicar(id), HandlerDef(this, "controllers.compras.OrdenesController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """compras/orden/duplicar""")
)
                      
    
}
                          

// @LINE:92
// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:87
// @LINE:86
// @LINE:85
// @LINE:84
// @LINE:83
// @LINE:82
class ReverseSolicitudAccionesController {
    

// @LINE:86
def modalPasarAprobadoPorPresupuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.modalPasarAprobadoPorPresupuesto(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalPasarAprobadoPorPresupuesto", Seq(), "GET", """""", _prefix + """compras/solicitud/modalPasarAprobadoPorPresupuesto""")
)
                      

// @LINE:92
def asignarUsuario(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.asignarUsuario(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "asignarUsuario", Seq(), "POST", """""", _prefix + """compras/solicitud/asignarUsuario""")
)
                      

// @LINE:87
def pasarAprobadoPorPresupuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.pasarAprobadoPorPresupuesto(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "pasarAprobadoPorPresupuesto", Seq(), "POST", """""", _prefix + """compras/solicitud/pasarAprobadoPorPresupuesto""")
)
                      

// @LINE:83
def importarListaProductos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.importarListaProductos(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "importarListaProductos", Seq(), "POST", """""", _prefix + """compras/solicitud/importarListaProductos""")
)
                      

// @LINE:85
def modificarPaciente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.modificarPaciente(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modificarPaciente", Seq(), "POST", """""", _prefix + """compras/solicitud/modificarPaciente""")
)
                      

// @LINE:89
def pasarAutorizado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.pasarAutorizado(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "pasarAutorizado", Seq(), "POST", """""", _prefix + """compras/solicitud/pasarAutorizado""")
)
                      

// @LINE:84
def modalModificarPaciente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.modalModificarPaciente(id), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalModificarPaciente", Seq(classOf[Long]), "GET", """""", _prefix + """compras/solicitud/modalModificarPacientes""")
)
                      

// @LINE:91
def modalAsignarUsuario(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.modalAsignarUsuario(id), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalAsignarUsuario", Seq(classOf[Long]), "GET", """""", _prefix + """compras/solicitud/modalAsignarUsuario""")
)
                      

// @LINE:82
def modalImportarListaProductos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.modalImportarListaProductos(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalImportarListaProductos", Seq(), "POST", """""", _prefix + """compras/solicitud/modalImportarListaProductos""")
)
                      

// @LINE:88
def modalPasarAutorizado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudAccionesController.modalPasarAutorizado(), HandlerDef(this, "controllers.compras.SolicitudAccionesController", "modalPasarAutorizado", Seq(), "GET", """""", _prefix + """compras/solicitud/modalPasarAutorizado""")
)
                      
    
}
                          

// @LINE:268
// @LINE:265
class ReverseProveedoresAccionesController {
    

// @LINE:268
def actualizarMail(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresAccionesController.actualizarMail(), HandlerDef(this, "controllers.compras.ProveedoresAccionesController", "actualizarMail", Seq(), "POST", """""", _prefix + """compras/proveedores/actualizarMail""")
)
                      

// @LINE:265
def modalInformacionProveedor(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProveedoresAccionesController.modalInformacionProveedor(id), HandlerDef(this, "controllers.compras.ProveedoresAccionesController", "modalInformacionProveedor", Seq(classOf[Long]), "GET", """""", _prefix + """compras/proveedores/modalInformacionProveedor""")
)
                      
    
}
                          

// @LINE:376
class ReverseCertificacionesComprasReportesController {
    

// @LINE:376
def reporteCertificacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasReportesController.reporteCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesComprasReportesController", "reporteCertificacion", Seq(), "POST", """""", _prefix + """compras/certificaciones-compra/reporteCertificacion""")
)
                      
    
}
                          

// @LINE:1034
// @LINE:81
// @LINE:80
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
class ReverseSolicitudesController {
    

// @LINE:75
def cambiarEstado(idSolicitud:Long, idEstado:Long, searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.cambiarEstado(idSolicitud, idEstado, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "cambiarEstado", Seq(classOf[Long], classOf[Long], classOf[String]), "GET", """""", _prefix + """compras/solicitud/cambiarEstado""")
)
                      

// @LINE:68
def guardarSolicitud(searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.guardarSolicitud(searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "guardarSolicitud", Seq(classOf[String]), "POST", """""", _prefix + """compras/solicitud/guardar""")
)
                      

// @LINE:70
def editar(id:Long, searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.editar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "editar", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """compras/solicitud/editar""")
)
                      

// @LINE:67
def crearSolicitud(searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.crearSolicitud(searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "crearSolicitud", Seq(classOf[String]), "GET", """""", _prefix + """compras/solicitud/crear""")
)
                      

// @LINE:76
def redirectSearchIndex(searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.redirectSearchIndex(searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "redirectSearchIndex", Seq(classOf[String]), "GET", """""", _prefix + """compras/solicitud/redirectIndex""")
)
                      

// @LINE:1034
def suggestSolicitud(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.suggestSolicitud(input), HandlerDef(this, "controllers.compras.SolicitudesController", "suggestSolicitud", Seq(classOf[String]), "GET", """""", _prefix + """suggestSolicitud/$input<[^/]+>""")
)
                      

// @LINE:81
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.get(id), HandlerDef(this, "controllers.compras.SolicitudesController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """compras/solicitud/get""")
)
                      

// @LINE:72
def eliminar(id:Long, searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.eliminar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "eliminar", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """compras/solicitud/eliminar""")
)
                      

// @LINE:78
def modalEditarCuentaAnalica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.modalEditarCuentaAnalica(), HandlerDef(this, "controllers.compras.SolicitudesController", "modalEditarCuentaAnalica", Seq(), "GET", """""", _prefix + """compras/solicitud/modalEditarCuentaAnalitica""")
)
                      

// @LINE:80
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.modalBuscar(), HandlerDef(this, "controllers.compras.SolicitudesController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/solicitud/modalBuscar""")
)
                      

// @LINE:79
def editarCuentaAnalitica(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.editarCuentaAnalitica(), HandlerDef(this, "controllers.compras.SolicitudesController", "editarCuentaAnalitica", Seq(), "POST", """""", _prefix + """compras/solicitud/editarCuentaAnalitica""")
)
                      

// @LINE:69
def ver(id:Long, searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.ver(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "ver", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """compras/solicitud/ver""")
)
                      

// @LINE:71
def duplicar(id:Long, searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.duplicar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "duplicar", Seq(classOf[Long], classOf[String]), "GET", """""", _prefix + """compras/solicitud/duplicar""")
)
                      

// @LINE:74
def modificarEntregado(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.modificarEntregado(id), HandlerDef(this, "controllers.compras.SolicitudesController", "modificarEntregado", Seq(classOf[Long]), "GET", """""", _prefix + """compras/solicitud/modificarEntregado""")
)
                      

// @LINE:66
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.index(), HandlerDef(this, "controllers.compras.SolicitudesController", "index", Seq(), "GET", """""", _prefix + """compras/solicitud""")
)
                      

// @LINE:73
def actualizar(id:Long, searchIndex:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.SolicitudesController.actualizar(id, searchIndex), HandlerDef(this, "controllers.compras.SolicitudesController", "actualizar", Seq(classOf[Long], classOf[String]), "POST", """""", _prefix + """compras/solicitud/actualizar""")
)
                      
    
}
                          

// @LINE:213
// @LINE:194
// @LINE:189
// @LINE:188
// @LINE:187
class ReverseCertificacionesReportesController {
    

// @LINE:189
def bajas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesReportesController.bajas(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "bajas", Seq(), "POST", """""", _prefix + """compras/certificacion/reportes/bajas""")
)
                      

// @LINE:188
def reporteElevaciones(desc:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesReportesController.reporteElevaciones(desc), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reporteElevaciones", Seq(classOf[Boolean]), "POST", """""", _prefix + """compras/reporteElevaciones""")
)
                      

// @LINE:187
def reporteTasas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesReportesController.reporteTasas(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reporteTasas", Seq(), "POST", """""", _prefix + """compras/reporteTasa""")
)
                      

// @LINE:194
def reportePlanillaSueldos(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesReportesController.reportePlanillaSueldos(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reportePlanillaSueldos", Seq(), "POST", """""", _prefix + """compras/reportePlanilla""")
)
                      

// @LINE:213
def reporteCertificacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesReportesController.reporteCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesReportesController", "reporteCertificacion", Seq(), "POST", """""", _prefix + """compras/certificaciones/reporteCertificacion""")
)
                      
    
}
                          

// @LINE:1044
// @LINE:1041
// @LINE:1040
// @LINE:1023
// @LINE:300
// @LINE:299
// @LINE:298
// @LINE:297
// @LINE:296
// @LINE:295
// @LINE:294
// @LINE:293
// @LINE:292
// @LINE:291
// @LINE:290
// @LINE:289
// @LINE:288
// @LINE:287
// @LINE:286
// @LINE:285
class ReverseProductosController {
    

// @LINE:289
def editarProducto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.editarProducto(id), HandlerDef(this, "controllers.compras.ProductosController", "editarProducto", Seq(classOf[Long]), "GET", """""", _prefix + """compras/productos/editar""")
)
                      

// @LINE:294
def modalBuscarSolicitudes(idSolicitud:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.modalBuscarSolicitudes(idSolicitud), HandlerDef(this, "controllers.compras.ProductosController", "modalBuscarSolicitudes", Seq(classOf[Long]), "GET", """""", _prefix + """compras/producto/modalBuscarSolicitudes""")
)
                      

// @LINE:1023
def suggestUdm(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.suggestUdm(input), HandlerDef(this, "controllers.compras.ProductosController", "suggestUdm", Seq(classOf[String]), "GET", """""", _prefix + """suggestUdm/$input<[^/]+>""")
)
                      

// @LINE:295
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.get(id), HandlerDef(this, "controllers.compras.ProductosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """compras/producto/get""")
)
                      

// @LINE:298
def cargaProductoRismi(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.cargaProductoRismi(), HandlerDef(this, "controllers.compras.ProductosController", "cargaProductoRismi", Seq(), "GET", """""", _prefix + """compras/producto/cargaProductoRismi""")
)
                      

// @LINE:291
def actualizarProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.actualizarProducto(), HandlerDef(this, "controllers.compras.ProductosController", "actualizarProducto", Seq(), "POST", """""", _prefix + """compras/producto/actualizar""")
)
                      

// @LINE:286
def listarProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.listarProducto(), HandlerDef(this, "controllers.compras.ProductosController", "listarProducto", Seq(), "GET", """""", _prefix + """compras/productos/""")
)
                      

// @LINE:1040
def suggestProducto(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.suggestProducto(input), HandlerDef(this, "controllers.compras.ProductosController", "suggestProducto", Seq(classOf[String]), "GET", """""", _prefix + """suggestProducto/$input<[^/]+>""")
)
                      

// @LINE:296
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.ver(id), HandlerDef(this, "controllers.compras.ProductosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """compras/producto/ver""")
)
                      

// @LINE:290
def eliminarProducto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.eliminarProducto(id), HandlerDef(this, "controllers.compras.ProductosController", "eliminarProducto", Seq(classOf[Long]), "GET", """""", _prefix + """compras/productos/eliminar""")
)
                      

// @LINE:285
def indexProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.indexProducto(), HandlerDef(this, "controllers.compras.ProductosController", "indexProducto", Seq(), "GET", """""", _prefix + """compras/productos""")
)
                      

// @LINE:292
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.modalBuscar(), HandlerDef(this, "controllers.compras.ProductosController", "modalBuscar", Seq(), "GET", """""", _prefix + """compras/producto/modalBuscar""")
)
                      

// @LINE:299
def modalCarga(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.modalCarga(), HandlerDef(this, "controllers.compras.ProductosController", "modalCarga", Seq(), "GET", """""", _prefix + """compras/producto/modalCargar""")
)
                      

// @LINE:288
def guardarProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.guardarProducto(), HandlerDef(this, "controllers.compras.ProductosController", "guardarProducto", Seq(), "POST", """""", _prefix + """compras/productos/guardar""")
)
                      

// @LINE:293
def modalBuscarIps(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.modalBuscarIps(), HandlerDef(this, "controllers.compras.ProductosController", "modalBuscarIps", Seq(), "GET", """""", _prefix + """compras/producto/modalBuscarIps""")
)
                      

// @LINE:300
def guardarProductoDesdeModal(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.guardarProductoDesdeModal(), HandlerDef(this, "controllers.compras.ProductosController", "guardarProductoDesdeModal", Seq(), "POST", """""", _prefix + """compras/producto/guardarProductoDesdeModal""")
)
                      

// @LINE:1044
def getDataSuggestSolicitud(input:String, idDeposito:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.getDataSuggestSolicitud(input, idDeposito), HandlerDef(this, "controllers.compras.ProductosController", "getDataSuggestSolicitud", Seq(classOf[String], classOf[Long]), "GET", """""", _prefix + """suggestProductoSolicitud/$idDeposito<[^/]+>/$input<[^/]+>""")
)
                      

// @LINE:297
def getPrecioProducto(producto_id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.getPrecioProducto(producto_id), HandlerDef(this, "controllers.compras.ProductosController", "getPrecioProducto", Seq(classOf[Int]), "GET", """""", _prefix + """compras/producto/getPrecio""")
)
                      

// @LINE:287
def crearProducto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.crearProducto(), HandlerDef(this, "controllers.compras.ProductosController", "crearProducto", Seq(), "GET", """""", _prefix + """compras/productos/crear""")
)
                      

// @LINE:1041
def suggestProductoPresupuesto(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.ProductosController.suggestProductoPresupuesto(input), HandlerDef(this, "controllers.compras.ProductosController", "suggestProductoPresupuesto", Seq(classOf[String]), "GET", """""", _prefix + """suggestProductoPresupuesto/$input<[^/]+>""")
)
                      
    
}
                          

// @LINE:367
// @LINE:366
// @LINE:365
// @LINE:364
// @LINE:363
// @LINE:362
// @LINE:361
// @LINE:360
// @LINE:359
// @LINE:358
class ReverseCertificacionesComprasAccionesController {
    

// @LINE:361
def pasarCertificadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.pasarCertificadoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarCertificadoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/pasarCertificadoMasivo""")
)
                      

// @LINE:362
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.modalPasarBorrador(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/modalPasarBorrador""")
)
                      

// @LINE:365
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/pasarCanceladoMasivo""")
)
                      

// @LINE:363
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.pasarBorradorMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/pasarBorradorMasivo""")
)
                      

// @LINE:366
def modalEditarFechaCertificacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.modalEditarFechaCertificacion(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalEditarFechaCertificacion", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/modalEditarFechaCertificacion""")
)
                      

// @LINE:364
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.modalPasarCancelado(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/modalPasarCancelado""")
)
                      

// @LINE:367
def editarFechaCertificacionMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.editarFechaCertificacionMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "editarFechaCertificacionMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/editarFechaCertificacionMasivo""")
)
                      

// @LINE:358
def modalPasarEnCurso(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.modalPasarEnCurso(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarEnCurso", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/modalPasarEnCurso""")
)
                      

// @LINE:360
def modalPasarCertificado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.modalPasarCertificado(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "modalPasarCertificado", Seq(), "GET", """""", _prefix + """compras/certificacion-compra/modalPasarCertificado""")
)
                      

// @LINE:359
def pasarEnCursoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.compras.CertificacionesComprasAccionesController.pasarEnCursoMasivo(), HandlerDef(this, "controllers.compras.CertificacionesComprasAccionesController", "pasarEnCursoMasivo", Seq(), "POST", """""", _prefix + """compras/certificacion-compra/pasarEnCursoMasivo""")
)
                      
    
}
                          
}
        

// @LINE:1053
// @LINE:1033
// @LINE:1030
// @LINE:1029
// @LINE:1028
// @LINE:1027
// @LINE:1026
// @LINE:663
// @LINE:662
// @LINE:661
// @LINE:660
// @LINE:659
// @LINE:658
// @LINE:656
// @LINE:655
// @LINE:654
// @LINE:653
// @LINE:652
// @LINE:651
// @LINE:649
// @LINE:648
// @LINE:646
// @LINE:645
// @LINE:643
// @LINE:642
// @LINE:640
// @LINE:638
// @LINE:637
// @LINE:636
// @LINE:635
// @LINE:634
// @LINE:633
// @LINE:632
// @LINE:631
// @LINE:629
// @LINE:628
// @LINE:627
// @LINE:626
// @LINE:625
// @LINE:624
// @LINE:622
// @LINE:621
// @LINE:620
// @LINE:618
// @LINE:617
// @LINE:616
// @LINE:615
// @LINE:613
// @LINE:612
// @LINE:611
// @LINE:610
// @LINE:609
// @LINE:608
// @LINE:607
// @LINE:606
// @LINE:605
// @LINE:602
// @LINE:600
// @LINE:599
// @LINE:598
// @LINE:597
// @LINE:596
// @LINE:595
// @LINE:594
// @LINE:593
// @LINE:592
// @LINE:591
// @LINE:589
// @LINE:588
// @LINE:587
// @LINE:586
// @LINE:585
// @LINE:584
// @LINE:583
// @LINE:582
// @LINE:581
// @LINE:580
// @LINE:579
// @LINE:578
// @LINE:576
// @LINE:575
// @LINE:574
// @LINE:573
// @LINE:572
// @LINE:571
// @LINE:570
// @LINE:569
// @LINE:567
// @LINE:566
// @LINE:565
// @LINE:564
// @LINE:563
// @LINE:562
// @LINE:561
// @LINE:560
// @LINE:559
// @LINE:557
// @LINE:556
// @LINE:554
// @LINE:553
// @LINE:551
// @LINE:550
// @LINE:549
// @LINE:548
// @LINE:547
// @LINE:546
// @LINE:545
// @LINE:544
// @LINE:542
// @LINE:541
// @LINE:540
// @LINE:539
// @LINE:538
// @LINE:537
// @LINE:535
// @LINE:534
// @LINE:533
// @LINE:532
// @LINE:531
// @LINE:530
// @LINE:528
// @LINE:527
// @LINE:526
// @LINE:525
// @LINE:524
// @LINE:523
// @LINE:521
// @LINE:520
// @LINE:519
// @LINE:518
// @LINE:517
// @LINE:516
// @LINE:514
// @LINE:513
// @LINE:512
// @LINE:511
// @LINE:510
// @LINE:509
// @LINE:507
// @LINE:506
// @LINE:505
// @LINE:504
// @LINE:503
// @LINE:502
// @LINE:501
// @LINE:500
// @LINE:499
// @LINE:498
package controllers.rrhh.ref {


// @LINE:663
// @LINE:662
// @LINE:661
// @LINE:660
// @LINE:659
// @LINE:658
class ReverseAgentesSeguimientoLineasController {
    

// @LINE:658
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoLineasController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/seguimiento-linea/index""")
)
                      

// @LINE:663
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoLineasController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/seguimiento-linea/eliminar""")
)
                      

// @LINE:661
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoLineasController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/seguimiento-linea/guardar""")
)
                      

// @LINE:662
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoLineasController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/seguimiento-linea/actualizar""")
)
                      

// @LINE:660
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoLineasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/seguimiento-linea/editar""")
)
                      

// @LINE:659
def crear(seguimientoId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoLineasController.crear(seguimientoId), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/seguimiento-linea/crear""")
)
                      
    
}
                          

// @LINE:507
// @LINE:506
// @LINE:505
// @LINE:504
// @LINE:503
// @LINE:502
// @LINE:501
class ReverseAgentesEstudiosController {
    

// @LINE:507
def listOptionsEstudioSubareas(estudioAreaId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.listOptionsEstudioSubareas(estudioAreaId), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "listOptionsEstudioSubareas", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/agente-estudio/listOptionsSubarea""")
)
                      

// @LINE:501
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/agente-estudio/index""")
)
                      

// @LINE:506
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-estudio/eliminar""")
)
                      

// @LINE:504
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/agente-estudio/guardar""")
)
                      

// @LINE:505
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/agente-estudio/actualizar""")
)
                      

// @LINE:503
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-estudio/editar""")
)
                      

// @LINE:502
def crear(agenteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesEstudiosController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesEstudiosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/agente-estudio/crear""")
)
                      
    
}
                          

// @LINE:528
// @LINE:527
// @LINE:526
// @LINE:525
// @LINE:524
// @LINE:523
class ReverseAgentesHijosController {
    

// @LINE:523
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesHijosController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/agente-hijo/index""")
)
                      

// @LINE:528
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesHijosController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-hijo/eliminar""")
)
                      

// @LINE:526
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesHijosController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/agente-hijo/guardar""")
)
                      

// @LINE:527
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesHijosController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/agente-hijo/actualizar""")
)
                      

// @LINE:525
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesHijosController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-hijo/editar""")
)
                      

// @LINE:524
def crear(agenteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesHijosController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesHijosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/agente-hijo/crear""")
)
                      
    
}
                          

// @LINE:646
// @LINE:645
class ReverseAgentesAsistenciasReportesController {
    

// @LINE:645
def reporteLicencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasReportesController.reporteLicencia(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasReportesController", "reporteLicencia", Seq(), "POST", """""", _prefix + """rrhh/agenteAsistencia/reporteLicencia""")
)
                      

// @LINE:646
def reporteLicenciaMedicinaLaboral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasReportesController.reporteLicenciaMedicinaLaboral(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasReportesController", "reporteLicenciaMedicinaLaboral", Seq(), "POST", """""", _prefix + """rrhh/agenteAsistencia/reporteLicenciaMedicinaLaboral""")
)
                      
    
}
                          

// @LINE:514
// @LINE:513
// @LINE:512
// @LINE:511
// @LINE:510
// @LINE:509
class ReverseAgentesRulController {
    

// @LINE:509
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesRulController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesRulController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/agente-rul/index""")
)
                      

// @LINE:514
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesRulController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesRulController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-rul/eliminar""")
)
                      

// @LINE:512
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesRulController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesRulController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/agente-rul/guardar""")
)
                      

// @LINE:513
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesRulController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesRulController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/agente-rul/actualizar""")
)
                      

// @LINE:511
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesRulController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesRulController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-rul/editar""")
)
                      

// @LINE:510
def crear(agenteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesRulController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesRulController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/agente-rul/crear""")
)
                      
    
}
                          

// @LINE:618
// @LINE:617
// @LINE:616
// @LINE:615
class ReverseAgentesReportesController {
    

// @LINE:617
def reportesDatosAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesReportesController.reportesDatosAgente(), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "reportesDatosAgente", Seq(), "POST", """""", _prefix + """rrhh/agente/reportes/reportesDatosAgente""")
)
                      

// @LINE:615
def ficha(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesReportesController.ficha(id), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "ficha", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/reportes/ficha""")
)
                      

// @LINE:616
def fichaAptitud(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesReportesController.fichaAptitud(id), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "fichaAptitud", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/reportes/fichaAptitud""")
)
                      

// @LINE:618
def reportesCertificacionesAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesReportesController.reportesCertificacionesAgente(), HandlerDef(this, "controllers.rrhh.AgentesReportesController", "reportesCertificacionesAgente", Seq(), "POST", """""", _prefix + """rrhh/agente/reportes/reportesCertificacionesAgente""")
)
                      
    
}
                          

// @LINE:1029
// @LINE:567
// @LINE:566
// @LINE:565
// @LINE:564
// @LINE:563
// @LINE:562
// @LINE:561
// @LINE:560
// @LINE:559
class ReverseTipoResidenciasController {
    

// @LINE:561
def indexTipoResidencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.indexTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "indexTipoResidencia", Seq(), "GET", """""", _prefix + """rrhh/tipoResidencia""")
)
                      

// @LINE:563
def guardarTipoResidencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.guardarTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "guardarTipoResidencia", Seq(), "POST", """""", _prefix + """rrhh/tipoResidencia/guardar""")
)
                      

// @LINE:560
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.get(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/tipoResidencia/get""")
)
                      

// @LINE:566
def actualizarTipoResidencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.actualizarTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "actualizarTipoResidencia", Seq(), "POST", """""", _prefix + """rrhh/tipoResidencia/actualizar""")
)
                      

// @LINE:562
def crearTipoResidencia(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.crearTipoResidencia(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "crearTipoResidencia", Seq(), "GET", """""", _prefix + """rrhh/tipoResidencia/crear""")
)
                      

// @LINE:567
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.ver(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/tipoResidencia/ver""")
)
                      

// @LINE:1029
def suggestTipoResidencia(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.suggestTipoResidencia(input), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "suggestTipoResidencia", Seq(classOf[String]), "GET", """""", _prefix + """suggestTipoResidencia/$input<[^/]+>""")
)
                      

// @LINE:565
def eliminarTipoResidencia(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.eliminarTipoResidencia(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "eliminarTipoResidencia", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/tipoResidencia/eliminar""")
)
                      

// @LINE:559
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.modalBuscar(), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/tipoResidencia/modalBuscar""")
)
                      

// @LINE:564
def editarTipoResidencia(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.TipoResidenciasController.editarTipoResidencia(id), HandlerDef(this, "controllers.rrhh.TipoResidenciasController", "editarTipoResidencia", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/tipoResidencia/editar""")
)
                      
    
}
                          

// @LINE:613
// @LINE:612
// @LINE:611
// @LINE:610
// @LINE:609
// @LINE:608
// @LINE:607
// @LINE:606
// @LINE:605
class ReverseNovedadesController {
    

// @LINE:608
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.crear(), HandlerDef(this, "controllers.rrhh.NovedadesController", "crear", Seq(), "GET", """""", _prefix + """rrhh/novedades/crear""")
)
                      

// @LINE:606
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.ver(id), HandlerDef(this, "controllers.rrhh.NovedadesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/novedades/ver""")
)
                      

// @LINE:607
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.eliminar(id), HandlerDef(this, "controllers.rrhh.NovedadesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/novedades/eliminar""")
)
                      

// @LINE:609
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.guardar(), HandlerDef(this, "controllers.rrhh.NovedadesController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/novedades/guardar""")
)
                      

// @LINE:611
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.actualizar(), HandlerDef(this, "controllers.rrhh.NovedadesController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/novedades/actualizar""")
)
                      

// @LINE:612
def lista(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.lista(), HandlerDef(this, "controllers.rrhh.NovedadesController", "lista", Seq(), "GET", """""", _prefix + """rrhh/novedades/lista""")
)
                      

// @LINE:613
def getFeriados(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.getFeriados(), HandlerDef(this, "controllers.rrhh.NovedadesController", "getFeriados", Seq(), "GET", """""", _prefix + """rrhh/novedades/feriados""")
)
                      

// @LINE:610
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.editar(id), HandlerDef(this, "controllers.rrhh.NovedadesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/novedades/editar""")
)
                      

// @LINE:605
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.NovedadesController.index(), HandlerDef(this, "controllers.rrhh.NovedadesController", "index", Seq(), "GET", """""", _prefix + """rrhh/novedades""")
)
                      
    
}
                          

// @LINE:1027
// @LINE:551
// @LINE:550
// @LINE:549
// @LINE:548
// @LINE:547
// @LINE:546
// @LINE:545
// @LINE:544
class ReverseEspecialidadesController {
    

// @LINE:1027
def suggestEspecialidad(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.suggestEspecialidad(input), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "suggestEspecialidad", Seq(classOf[String]), "GET", """""", _prefix + """suggestEspecialidad/$input<[^/]+>""")
)
                      

// @LINE:548
def eliminarEspecialidad(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.eliminarEspecialidad(id), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "eliminarEspecialidad", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/especialidad/eliminar""")
)
                      

// @LINE:549
def actualizarEspecialidad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.actualizarEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "actualizarEspecialidad", Seq(), "POST", """""", _prefix + """rrhh/especialidad/actualizar""")
)
                      

// @LINE:551
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.get(id), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/especialidad/get""")
)
                      

// @LINE:547
def editarEspecialidad(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.editarEspecialidad(id), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "editarEspecialidad", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/especialidad/editar""")
)
                      

// @LINE:550
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/especialidad/modalBuscar""")
)
                      

// @LINE:546
def guardarEspecialidad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.guardarEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "guardarEspecialidad", Seq(), "POST", """""", _prefix + """rrhh/especialidad/guardar""")
)
                      

// @LINE:545
def crearEspecialidad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.crearEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "crearEspecialidad", Seq(), "GET", """""", _prefix + """rrhh/especialidad/crear""")
)
                      

// @LINE:544
def indexEspecialidad(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.EspecialidadesController.indexEspecialidad(), HandlerDef(this, "controllers.rrhh.EspecialidadesController", "indexEspecialidad", Seq(), "GET", """""", _prefix + """rrhh/especialidad""")
)
                      
    
}
                          

// @LINE:643
// @LINE:642
// @LINE:640
// @LINE:638
// @LINE:637
// @LINE:636
// @LINE:635
// @LINE:634
// @LINE:633
// @LINE:632
// @LINE:631
// @LINE:629
// @LINE:628
// @LINE:627
// @LINE:626
// @LINE:625
// @LINE:624
class ReverseAgentesAsistenciasLicenciasController {
    

// @LINE:631
def modalPasarBorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarBorrador(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarBorrador", Seq(), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/modalPasarBorrador""")
)
                      

// @LINE:640
def resumen(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.resumen(id, editable), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "resumen", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/resumen""")
)
                      

// @LINE:624
def index(id:Long, editable:Boolean, tipoLicencia:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.index(id, editable, tipoLicencia), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "index", Seq(classOf[Long], classOf[Boolean], classOf[Long]), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/index""")
)
                      

// @LINE:636
def pasarPreAprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.pasarPreAprobadoMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarPreAprobadoMasivo", Seq(), "POST", """""", _prefix + """rrhh/agente-asistencia-licencia/pasarPreAprobadoMasivo""")
)
                      

// @LINE:643
def getListaLicenciasEnFecha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasEnFecha(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "getListaLicenciasEnFecha", Seq(), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/getListaLicenciasEnFecha""")
)
                      

// @LINE:629
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/eliminar""")
)
                      

// @LINE:637
def modalPasarAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarAprobado", Seq(), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/modalPasarAprobado""")
)
                      

// @LINE:627
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/agente-asistencia-licencian/guardar""")
)
                      

// @LINE:634
def pasarCanceladoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.pasarCanceladoMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarCanceladoMasivo", Seq(), "POST", """""", _prefix + """rrhh/agente-asistencia-licencia/pasarCanceladoMasivo""")
)
                      

// @LINE:628
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/agente-asistencia-licencia/actualizar""")
)
                      

// @LINE:632
def pasarBorradorMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.pasarBorradorMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarBorradorMasivo", Seq(), "POST", """""", _prefix + """rrhh/agente-asistencia-licencia/pasarBorradorMasivo""")
)
                      

// @LINE:642
def getListaLicenciasPendientes(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.getListaLicenciasPendientes(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "getListaLicenciasPendientes", Seq(), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/getListaLicenciasPendientes""")
)
                      

// @LINE:633
def modalPasarCancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarCancelado(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarCancelado", Seq(), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/modalPasarCancelado""")
)
                      

// @LINE:638
def pasarAprobadoMasivo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.pasarAprobadoMasivo(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "pasarAprobadoMasivo", Seq(), "POST", """""", _prefix + """rrhh/agente-asistencia-licencia/pasarAprobadoMasivo""")
)
                      

// @LINE:626
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/editar""")
)
                      

// @LINE:625
def crear(agenteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/crear""")
)
                      

// @LINE:635
def modalPasarPreAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasLicenciasController.modalPasarPreAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasLicenciasController", "modalPasarPreAprobado", Seq(), "GET", """""", _prefix + """rrhh/agente-asistencia-licencia/modalPasarPreAprobado""")
)
                      
    
}
                          

// @LINE:1053
// @LINE:557
// @LINE:556
class ReverseCiesController {
    

// @LINE:1053
def suggestCie(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.CiesController.suggestCie(input), HandlerDef(this, "controllers.rrhh.CiesController", "suggestCie", Seq(classOf[String]), "GET", """""", _prefix + """suggestCie/$input<[^/]+>""")
)
                      

// @LINE:556
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.CiesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.CiesController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/cie/modalBuscar""")
)
                      

// @LINE:557
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.CiesController.get(id), HandlerDef(this, "controllers.rrhh.CiesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/cie/get""")
)
                      
    
}
                          

// @LINE:1033
// @LINE:602
// @LINE:589
// @LINE:586
// @LINE:585
// @LINE:584
// @LINE:583
// @LINE:582
// @LINE:581
// @LINE:580
// @LINE:579
// @LINE:578
class ReverseAgentesController {
    

// @LINE:582
def eliminarAgente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.eliminarAgente(id), HandlerDef(this, "controllers.rrhh.AgentesController", "eliminarAgente", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/eliminar""")
)
                      

// @LINE:589
def cambiarEstado(idAgente:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.cambiarEstado(idAgente, idEstado), HandlerDef(this, "controllers.rrhh.AgentesController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """rrhh/agente/cambiar-estado""")
)
                      

// @LINE:602
def actualizarMail(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.actualizarMail(), HandlerDef(this, "controllers.rrhh.AgentesController", "actualizarMail", Seq(), "POST", """""", _prefix + """rrhh/agente/actualizarMail""")
)
                      

// @LINE:580
def guardarAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.guardarAgente(), HandlerDef(this, "controllers.rrhh.AgentesController", "guardarAgente", Seq(), "POST", """""", _prefix + """rrhh/agente/guardar""")
)
                      

// @LINE:581
def editarAgente(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.editarAgente(id), HandlerDef(this, "controllers.rrhh.AgentesController", "editarAgente", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/editar""")
)
                      

// @LINE:579
def crearAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.crearAgente(), HandlerDef(this, "controllers.rrhh.AgentesController", "crearAgente", Seq(), "GET", """""", _prefix + """rrhh/agente/crear""")
)
                      

// @LINE:583
def actualizarAgente(agenteId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.actualizarAgente(agenteId), HandlerDef(this, "controllers.rrhh.AgentesController", "actualizarAgente", Seq(classOf[Long]), "POST", """""", _prefix + """rrhh/agente/actualizar""")
)
                      

// @LINE:586
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.ver(id), HandlerDef(this, "controllers.rrhh.AgentesController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/ver""")
)
                      

// @LINE:585
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.get(id), HandlerDef(this, "controllers.rrhh.AgentesController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/get""")
)
                      

// @LINE:584
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.AgentesController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/agente/modalBuscar""")
)
                      

// @LINE:1033
def suggestAgente(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.suggestAgente(input), HandlerDef(this, "controllers.rrhh.AgentesController", "suggestAgente", Seq(classOf[String]), "GET", """""", _prefix + """suggestAgente/$input<[^/]+>""")
)
                      

// @LINE:578
def indexAgente(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesController.indexAgente(), HandlerDef(this, "controllers.rrhh.AgentesController", "indexAgente", Seq(), "GET", """""", _prefix + """rrhh/agente""")
)
                      
    
}
                          

// @LINE:521
// @LINE:520
// @LINE:519
// @LINE:518
// @LINE:517
// @LINE:516
class ReverseAgentesNovedadesController {
    

// @LINE:516
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesNovedadesController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/agente-novedad/index""")
)
                      

// @LINE:521
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesNovedadesController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-novedad/eliminar""")
)
                      

// @LINE:519
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesNovedadesController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/agente-novedad/guardar""")
)
                      

// @LINE:520
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesNovedadesController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/agente-novedad/actualizar""")
)
                      

// @LINE:518
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesNovedadesController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-novedad/editar""")
)
                      

// @LINE:517
def crear(agenteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesNovedadesController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesNovedadesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/agente-novedad/crear""")
)
                      
    
}
                          

// @LINE:535
// @LINE:534
// @LINE:533
// @LINE:532
// @LINE:531
// @LINE:530
class ReverseAgentesFamiliasController {
    

// @LINE:530
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesFamiliasController.index(id, editable), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """rrhh/agente-familia/index""")
)
                      

// @LINE:535
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesFamiliasController.eliminar(id), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-familia/eliminar""")
)
                      

// @LINE:533
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesFamiliasController.guardar(), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "guardar", Seq(), "POST", """""", _prefix + """rrhh/agente-familia/guardar""")
)
                      

// @LINE:534
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesFamiliasController.actualizar(), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "actualizar", Seq(), "POST", """""", _prefix + """rrhh/agente-familia/actualizar""")
)
                      

// @LINE:532
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesFamiliasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente-familia/editar""")
)
                      

// @LINE:531
def crear(agenteId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesFamiliasController.crear(agenteId), HandlerDef(this, "controllers.rrhh.AgentesFamiliasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """rrhh/agente-familia/crear""")
)
                      
    
}
                          

// @LINE:600
// @LINE:599
// @LINE:598
// @LINE:597
// @LINE:596
// @LINE:595
// @LINE:594
// @LINE:593
// @LINE:592
// @LINE:591
// @LINE:588
// @LINE:587
class ReverseAgentesAccionesController {
    

// @LINE:588
def replicarProveedor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.replicarProveedor(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "replicarProveedor", Seq(), "POST", """""", _prefix + """rrhh/agente/replicarProveedor""")
)
                      

// @LINE:596
def pasarACancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.pasarACancelado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarACancelado", Seq(), "POST", """""", _prefix + """rrhh/agente/pasarACancelado""")
)
                      

// @LINE:600
def pasarAPreaprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.pasarAPreaprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarAPreaprobado", Seq(), "POST", """""", _prefix + """rrhh/agente/pasarAPreaprobado""")
)
                      

// @LINE:597
def modalPasarACargado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.modalPasarACargado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarACargado", Seq(), "GET", """""", _prefix + """rrhh/agente/modalPasarACargado""")
)
                      

// @LINE:594
def pasarABorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.pasarABorrador(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarABorrador", Seq(), "POST", """""", _prefix + """rrhh/agente/pasarABorrador""")
)
                      

// @LINE:587
def modalReplicarProveedor(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.modalReplicarProveedor(id), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalReplicarProveedor", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agente/modalReplicarProveedor""")
)
                      

// @LINE:598
def pasarACargado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.pasarACargado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarACargado", Seq(), "POST", """""", _prefix + """rrhh/agente/pasarACargado""")
)
                      

// @LINE:595
def modalPasarACancelado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.modalPasarACancelado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarACancelado", Seq(), "GET", """""", _prefix + """rrhh/agente/modalPasarACancelado""")
)
                      

// @LINE:591
def modalPasarAAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.modalPasarAAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarAAprobado", Seq(), "GET", """""", _prefix + """rrhh/agente/modalPasarAAprobado""")
)
                      

// @LINE:592
def pasarAAprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.pasarAAprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "pasarAAprobado", Seq(), "POST", """""", _prefix + """rrhh/agente/pasarAAprobado""")
)
                      

// @LINE:599
def modalPasarAPreaprobado(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.modalPasarAPreaprobado(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarAPreaprobado", Seq(), "GET", """""", _prefix + """rrhh/agente/modalPasarAPreaprobado""")
)
                      

// @LINE:593
def modalPasarABorrador(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAccionesController.modalPasarABorrador(), HandlerDef(this, "controllers.rrhh.AgentesAccionesController", "modalPasarABorrador", Seq(), "GET", """""", _prefix + """rrhh/agente/modalPasarABorrador""")
)
                      
    
}
                          

// @LINE:1028
// @LINE:554
// @LINE:553
class ReverseProfesionesController {
    

// @LINE:553
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.ProfesionesController.modalBuscar(), HandlerDef(this, "controllers.rrhh.ProfesionesController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/profesion/modalBuscar""")
)
                      

// @LINE:1028
def suggestProfesion(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.ProfesionesController.suggestProfesion(input), HandlerDef(this, "controllers.rrhh.ProfesionesController", "suggestProfesion", Seq(classOf[String]), "GET", """""", _prefix + """suggestProfesion/$input<[^/]+>""")
)
                      

// @LINE:554
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.ProfesionesController.get(id), HandlerDef(this, "controllers.rrhh.ProfesionesController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/profesion/get""")
)
                      
    
}
                          

// @LINE:498
class ReverseIndexController {
    

// @LINE:498
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.IndexController.index(), HandlerDef(this, "controllers.rrhh.IndexController", "index", Seq(), "GET", """-----------------------------MODULO RRHH ---------------------------------""", _prefix + """rrhh""")
)
                      
    
}
                          

// @LINE:1026
// @LINE:542
// @LINE:541
// @LINE:540
// @LINE:539
// @LINE:538
// @LINE:537
// @LINE:500
// @LINE:499
class ReverseDepartamentosController {
    

// @LINE:500
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.get(id), HandlerDef(this, "controllers.rrhh.DepartamentosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/departamento/get""")
)
                      

// @LINE:539
def guardarDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.guardarDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "guardarDepartamento", Seq(), "POST", """""", _prefix + """rrhh/departamento/guardar""")
)
                      

// @LINE:541
def eliminarDepartamento(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.eliminarDepartamento(id), HandlerDef(this, "controllers.rrhh.DepartamentosController", "eliminarDepartamento", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/departamento/eliminar""")
)
                      

// @LINE:540
def editarDepartamento(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.editarDepartamento(id), HandlerDef(this, "controllers.rrhh.DepartamentosController", "editarDepartamento", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/departamento/editar""")
)
                      

// @LINE:499
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.modalBuscar(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/departamento/modalBuscar""")
)
                      

// @LINE:537
def indexDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.indexDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "indexDepartamento", Seq(), "GET", """""", _prefix + """rrhh/departamento""")
)
                      

// @LINE:1026
def suggestDepartamento(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.suggestDepartamento(input), HandlerDef(this, "controllers.rrhh.DepartamentosController", "suggestDepartamento", Seq(classOf[String]), "GET", """""", _prefix + """suggestDepartamento/$input<[^/]+>""")
)
                      

// @LINE:538
def crearDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.crearDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "crearDepartamento", Seq(), "GET", """""", _prefix + """rrhh/departamento/crear""")
)
                      

// @LINE:542
def actualizarDepartamento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.DepartamentosController.actualizarDepartamento(), HandlerDef(this, "controllers.rrhh.DepartamentosController", "actualizarDepartamento", Seq(), "POST", """""", _prefix + """rrhh/departamento/actualizar""")
)
                      
    
}
                          

// @LINE:622
// @LINE:621
// @LINE:620
class ReverseAgentesAsistenciasController {
    

// @LINE:621
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasController.editar(id), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agenteAsistencia/editar""")
)
                      

// @LINE:620
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasController.index(), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasController", "index", Seq(), "GET", """""", _prefix + """rrhh/agenteAsistencia/index""")
)
                      

// @LINE:622
def ver(id:Long, tipoLicencia:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesAsistenciasController.ver(id, tipoLicencia), HandlerDef(this, "controllers.rrhh.AgentesAsistenciasController", "ver", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """rrhh/agenteAsistencia/ver""")
)
                      
    
}
                          

// @LINE:656
// @LINE:655
// @LINE:654
// @LINE:653
// @LINE:652
// @LINE:651
// @LINE:649
// @LINE:648
class ReverseAgentesSeguimientoController {
    

// @LINE:656
def cambiarEstado(idSeguimiento:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.cambiarEstado(idSeguimiento, idEstado), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """rrhh/agenteSeguimiento/cambiarEstado""")
)
                      

// @LINE:654
def actualizarAgenteSeguimiento(agenteId:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.actualizarAgenteSeguimiento(agenteId), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "actualizarAgenteSeguimiento", Seq(classOf[Long]), "POST", """""", _prefix + """rrhh/agenteSeguimiento/actualizar""")
)
                      

// @LINE:655
def eliminarAgenteSeguimiento(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.eliminarAgenteSeguimiento(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "eliminarAgenteSeguimiento", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agenteSeguimiento/eliminar""")
)
                      

// @LINE:651
def crearAgenteSeguimiento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.crearAgenteSeguimiento(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "crearAgenteSeguimiento", Seq(), "GET", """""", _prefix + """rrhh/agenteSeguimiento/crear""")
)
                      

// @LINE:653
def editarAgenteSeguimiento(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.editarAgenteSeguimiento(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "editarAgenteSeguimiento", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agenteSeguimiento/editar""")
)
                      

// @LINE:649
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.ver(id), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/agenteSeguimiento/ver""")
)
                      

// @LINE:652
def guardarAgenteSeguimiento(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.guardarAgenteSeguimiento(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "guardarAgenteSeguimiento", Seq(), "POST", """""", _prefix + """rrhh/agenteSeguimiento/guardar""")
)
                      

// @LINE:648
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.AgentesSeguimientoController.index(), HandlerDef(this, "controllers.rrhh.AgentesSeguimientoController", "index", Seq(), "GET", """""", _prefix + """rrhh/agenteSeguimiento/index""")
)
                      
    
}
                          

// @LINE:1030
// @LINE:576
// @LINE:575
// @LINE:574
// @LINE:573
// @LINE:572
// @LINE:571
// @LINE:570
// @LINE:569
class ReversePuestosController {
    

// @LINE:574
def actualizarPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.actualizarPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "actualizarPuesto", Seq(), "POST", """""", _prefix + """rrhh/puesto/actualizar""")
)
                      

// @LINE:569
def indexPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.indexPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "indexPuesto", Seq(), "GET", """""", _prefix + """rrhh/puesto""")
)
                      

// @LINE:576
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.get(id), HandlerDef(this, "controllers.rrhh.PuestosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """rrhh/puesto/get""")
)
                      

// @LINE:575
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.modalBuscar(), HandlerDef(this, "controllers.rrhh.PuestosController", "modalBuscar", Seq(), "GET", """""", _prefix + """rrhh/puesto/modalBuscar""")
)
                      

// @LINE:1030
def suggestPuesto(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.suggestPuesto(input), HandlerDef(this, "controllers.rrhh.PuestosController", "suggestPuesto", Seq(classOf[String]), "GET", """""", _prefix + """suggestPuesto/$input<[^/]+>""")
)
                      

// @LINE:571
def guardarPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.guardarPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "guardarPuesto", Seq(), "POST", """""", _prefix + """rrhh/puesto/guardar""")
)
                      

// @LINE:570
def crearPuesto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.crearPuesto(), HandlerDef(this, "controllers.rrhh.PuestosController", "crearPuesto", Seq(), "GET", """""", _prefix + """rrhh/puesto/crear""")
)
                      

// @LINE:573
def eliminarPuesto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.eliminarPuesto(id), HandlerDef(this, "controllers.rrhh.PuestosController", "eliminarPuesto", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/puesto/eliminar""")
)
                      

// @LINE:572
def editarPuesto(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.rrhh.PuestosController.editarPuesto(id), HandlerDef(this, "controllers.rrhh.PuestosController", "editarPuesto", Seq(classOf[Long]), "GET", """""", _prefix + """rrhh/puesto/editar""")
)
                      
    
}
                          
}
        

// @LINE:1054
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:13
package controllers.ref {


// @LINE:1054
class ReverseAssets {
    

// @LINE:1054
def at(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.at(path, file), HandlerDef(this, "controllers.Assets", "at", Seq(classOf[String], classOf[String]), "GET", """""", _prefix + """assets/$file<.+>""")
)
                      
    
}
                          

// @LINE:17
// @LINE:16
// @LINE:15
class ReverseAuthentication {
    

// @LINE:17
def logout(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.logout(), HandlerDef(this, "controllers.Authentication", "logout", Seq(), "GET", """""", _prefix + """logout""")
)
                      

// @LINE:16
def authenticate(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.authenticate(), HandlerDef(this, "controllers.Authentication", "authenticate", Seq(), "POST", """""", _prefix + """login""")
)
                      

// @LINE:15
def login(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Authentication.login(), HandlerDef(this, "controllers.Authentication", "login", Seq(), "GET", """GET   /reporte             controllers.Reportes.index()""", _prefix + """login""")
)
                      
    
}
                          

// @LINE:13
class ReverseApplication {
    

// @LINE:13
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.index(), HandlerDef(this, "controllers.Application", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          
}
        

// @LINE:1038
// @LINE:677
// @LINE:676
// @LINE:675
// @LINE:674
// @LINE:673
// @LINE:672
// @LINE:671
// @LINE:670
// @LINE:669
package controllers.delegacion.ref {


// @LINE:1038
// @LINE:677
// @LINE:676
// @LINE:675
// @LINE:674
// @LINE:673
// @LINE:672
// @LINE:671
// @LINE:670
class ReverseDepositosController {
    

// @LINE:671
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.crear(), HandlerDef(this, "controllers.delegacion.DepositosController", "crear", Seq(), "GET", """""", _prefix + """delegacion/deposito/crear""")
)
                      

// @LINE:677
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.get(id), HandlerDef(this, "controllers.delegacion.DepositosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """delegacion/deposito/get""")
)
                      

// @LINE:674
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.eliminar(id), HandlerDef(this, "controllers.delegacion.DepositosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """delegacion/deposito/eliminar""")
)
                      

// @LINE:672
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.guardar(), HandlerDef(this, "controllers.delegacion.DepositosController", "guardar", Seq(), "POST", """""", _prefix + """delegacion/deposito/guardar""")
)
                      

// @LINE:675
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.actualizar(), HandlerDef(this, "controllers.delegacion.DepositosController", "actualizar", Seq(), "POST", """""", _prefix + """delegacion/deposito/actualizar""")
)
                      

// @LINE:676
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.modalBuscar(), HandlerDef(this, "controllers.delegacion.DepositosController", "modalBuscar", Seq(), "GET", """""", _prefix + """delegacion/deposito/modalBuscar""")
)
                      

// @LINE:1038
def suggestDeposito(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.suggestDeposito(input), HandlerDef(this, "controllers.delegacion.DepositosController", "suggestDeposito", Seq(classOf[String]), "GET", """""", _prefix + """suggestDeposito/$input<[^/]+>""")
)
                      

// @LINE:673
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.editar(id), HandlerDef(this, "controllers.delegacion.DepositosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """delegacion/deposito/editar""")
)
                      

// @LINE:670
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.DepositosController.index(), HandlerDef(this, "controllers.delegacion.DepositosController", "index", Seq(), "GET", """""", _prefix + """delegacion/deposito""")
)
                      
    
}
                          

// @LINE:669
class ReverseIndexController {
    

// @LINE:669
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.delegacion.IndexController.index(), HandlerDef(this, "controllers.delegacion.IndexController", "index", Seq(), "GET", """-----------------------------MODULO DELEGACIONES ---------------------------------""", _prefix + """delegacion""")
)
                      
    
}
                          
}
        

// @LINE:1050
// @LINE:1032
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
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
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:22
// @LINE:21
package controllers.administracion.ref {


// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:30
// @LINE:29
// @LINE:28
// @LINE:27
class ReverseUsuariosController {
    

// @LINE:33
def suggest(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.suggest(input), HandlerDef(this, "controllers.administracion.UsuariosController", "suggest", Seq(classOf[String]), "GET", """""", _prefix + """administracion/usuarios/suggest/$input<[^/]+>""")
)
                      

// @LINE:28
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.crear(), HandlerDef(this, "controllers.administracion.UsuariosController", "crear", Seq(), "GET", """""", _prefix + """administracion/usuarios/crear""")
)
                      

// @LINE:30
def editar(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.editar(id), HandlerDef(this, "controllers.administracion.UsuariosController", "editar", Seq(classOf[Integer]), "GET", """""", _prefix + """administracion/usuarios/editar""")
)
                      

// @LINE:35
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.get(id), HandlerDef(this, "controllers.administracion.UsuariosController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """administracion/usuarios/get""")
)
                      

// @LINE:29
def eliminar(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.eliminar(id), HandlerDef(this, "controllers.administracion.UsuariosController", "eliminar", Seq(classOf[Integer]), "GET", """""", _prefix + """administracion/usuarios/eliminar""")
)
                      

// @LINE:32
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.guardar(), HandlerDef(this, "controllers.administracion.UsuariosController", "guardar", Seq(), "POST", """""", _prefix + """administracion/usuarios/guardar""")
)
                      

// @LINE:31
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.actualizar(), HandlerDef(this, "controllers.administracion.UsuariosController", "actualizar", Seq(), "POST", """""", _prefix + """administracion/usuarios/actualizar""")
)
                      

// @LINE:34
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.modalBuscar(), HandlerDef(this, "controllers.administracion.UsuariosController", "modalBuscar", Seq(), "GET", """""", _prefix + """administracion/usuarios/modalBuscar""")
)
                      

// @LINE:27
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.UsuariosController.index(), HandlerDef(this, "controllers.administracion.UsuariosController", "index", Seq(), "GET", """""", _prefix + """administracion/usuarios""")
)
                      
    
}
                          

// @LINE:1050
// @LINE:22
// @LINE:21
class ReverseOrganigramasController {
    

// @LINE:21
def modalBuscarServicios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.OrganigramasController.modalBuscarServicios(), HandlerDef(this, "controllers.administracion.OrganigramasController", "modalBuscarServicios", Seq(), "GET", """--
-----------------------------ORGANIGRAMAS------------------------------------------------------------""", _prefix + """administracion/organigrama/modal-buscar-sevicios""")
)
                      

// @LINE:22
def get(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.OrganigramasController.get(id), HandlerDef(this, "controllers.administracion.OrganigramasController", "get", Seq(classOf[Long]), "GET", """""", _prefix + """administracion/organigrama/get""")
)
                      

// @LINE:1050
def suggestOrganigrama(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.OrganigramasController.suggestOrganigrama(input), HandlerDef(this, "controllers.administracion.OrganigramasController", "suggestOrganigrama", Seq(classOf[String]), "GET", """""", _prefix + """suggestOrganigrama/$input<[^/]+>""")
)
                      
    
}
                          

// @LINE:38
// @LINE:37
// @LINE:36
class ReversePermisosController {
    

// @LINE:38
def desasignar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.PermisosController.desasignar(), HandlerDef(this, "controllers.administracion.PermisosController", "desasignar", Seq(), "GET", """""", _prefix + """administracion/desasignar""")
)
                      

// @LINE:36
def index(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.PermisosController.index(id), HandlerDef(this, "controllers.administracion.PermisosController", "index", Seq(classOf[Int]), "GET", """""", _prefix + """administracion/permisos""")
)
                      

// @LINE:37
def asignar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.PermisosController.asignar(), HandlerDef(this, "controllers.administracion.PermisosController", "asignar", Seq(), "GET", """""", _prefix + """administracion/asignar""")
)
                      
    
}
                          

// @LINE:39
class ReverseProvinciasController {
    

// @LINE:39
def listOptions(paisId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.ProvinciasController.listOptions(paisId), HandlerDef(this, "controllers.administracion.ProvinciasController", "listOptions", Seq(classOf[Int]), "GET", """""", _prefix + """administracion/provincias/listOptions""")
)
                      
    
}
                          

// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:54
// @LINE:53
// @LINE:52
// @LINE:51
class ReverseTicketsController {
    

// @LINE:56
def cambiarEstado(id:Long, estado_id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.cambiarEstado(id, estado_id), HandlerDef(this, "controllers.administracion.TicketsController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """administracion/tickets/cambiarEstado""")
)
                      

// @LINE:52
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.crear(), HandlerDef(this, "controllers.administracion.TicketsController", "crear", Seq(), "GET", """""", _prefix + """administracion/tickets/crear""")
)
                      

// @LINE:57
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.ver(id), HandlerDef(this, "controllers.administracion.TicketsController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """administracion/tickets/ver""")
)
                      

// @LINE:58
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.eliminar(id), HandlerDef(this, "controllers.administracion.TicketsController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """administracion/tickets/eliminar""")
)
                      

// @LINE:53
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.guardar(), HandlerDef(this, "controllers.administracion.TicketsController", "guardar", Seq(), "POST", """""", _prefix + """administracion/tickets/guardar""")
)
                      

// @LINE:55
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.actualizar(), HandlerDef(this, "controllers.administracion.TicketsController", "actualizar", Seq(), "POST", """""", _prefix + """administracion/tickets/actualizar""")
)
                      

// @LINE:54
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.editar(id), HandlerDef(this, "controllers.administracion.TicketsController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """administracion/tickets/editar""")
)
                      

// @LINE:51
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.TicketsController.index(), HandlerDef(this, "controllers.administracion.TicketsController", "index", Seq(), "GET", """""", _prefix + """administracion/tickets""")
)
                      
    
}
                          

// @LINE:26
class ReverseIndexController {
    

// @LINE:26
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.IndexController.index(), HandlerDef(this, "controllers.administracion.IndexController", "index", Seq(), "GET", """-----------------------------MODULO ADMINISTRACION ---------------------------------""", _prefix + """administracion""")
)
                      
    
}
                          

// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:44
// @LINE:43
// @LINE:42
// @LINE:41
class ReverseGruposController {
    

// @LINE:42
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.crear(), HandlerDef(this, "controllers.administracion.GruposController", "crear", Seq(), "GET", """""", _prefix + """administracion/grupos/crear""")
)
                      

// @LINE:44
def editar(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.editar(id), HandlerDef(this, "controllers.administracion.GruposController", "editar", Seq(classOf[Integer]), "GET", """""", _prefix + """administracion/grupos/editar""")
)
                      

// @LINE:48
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.get(id), HandlerDef(this, "controllers.administracion.GruposController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """administracion/grupos/get""")
)
                      

// @LINE:43
def eliminar(id:Integer): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.eliminar(id), HandlerDef(this, "controllers.administracion.GruposController", "eliminar", Seq(classOf[Integer]), "GET", """""", _prefix + """administracion/grupos/eliminar""")
)
                      

// @LINE:46
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.guardar(), HandlerDef(this, "controllers.administracion.GruposController", "guardar", Seq(), "POST", """""", _prefix + """administracion/grupos/guardar""")
)
                      

// @LINE:45
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.actualizar(), HandlerDef(this, "controllers.administracion.GruposController", "actualizar", Seq(), "POST", """""", _prefix + """administracion/grupos/actualizar""")
)
                      

// @LINE:47
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.modalBuscar(), HandlerDef(this, "controllers.administracion.GruposController", "modalBuscar", Seq(), "GET", """""", _prefix + """administracion/grupos/modalBuscar""")
)
                      

// @LINE:41
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.GruposController.index(), HandlerDef(this, "controllers.administracion.GruposController", "index", Seq(), "GET", """""", _prefix + """administracion/grupos""")
)
                      
    
}
                          

// @LINE:1032
// @LINE:40
class ReverseLocalidadesController {
    

// @LINE:1032
def suggestLocalidad(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.LocalidadesController.suggestLocalidad(input), HandlerDef(this, "controllers.administracion.LocalidadesController", "suggestLocalidad", Seq(classOf[String]), "GET", """""", _prefix + """suggestLocalidad/$input<[^/]+>""")
)
                      

// @LINE:40
def listOptions(provinciaId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.administracion.LocalidadesController.listOptions(provinciaId), HandlerDef(this, "controllers.administracion.LocalidadesController", "listOptions", Seq(classOf[Int]), "GET", """""", _prefix + """administracion/localidades/listOptions""")
)
                      
    
}
                          
}
        
    