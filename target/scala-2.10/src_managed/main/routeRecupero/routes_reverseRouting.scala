// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeRecupero.routes
// @HASH:7c49588c87f1e2a5c9494516b9372059b82f7202
// @DATE:Tue Oct 04 11:43:25 ART 2022

import routeRecupero.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:74
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
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
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
package controllers.recupero {

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
class ReverseRecuperoPlanillasController {
    

// @LINE:72
def suggestRecuperoPlanilla(input:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "suggestRecuperoPlanilla/" + implicitly[PathBindable[String]].unbind("input", dynamicString(input)))
}
                                                

// @LINE:64
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla/crear")
}
                                                

// @LINE:69
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "planilla/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:71
def get(id:Int = 0): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla/get" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Int]].unbind("id", id)))))
}
                                                

// @LINE:68
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:67
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:65
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "planilla/guardar")
}
                                                

// @LINE:70
def modalBuscar(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla/modalBuscar")
}
                                                

// @LINE:66
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:63
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "planilla")
}
                                                
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseRecuperoFacturasController {
    

// @LINE:29
def cambiarEstado(idRecuperoFactura:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idRecuperoFactura", idRecuperoFactura)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:23
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura/crear")
}
                                                

// @LINE:28
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:27
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:26
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:24
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura/guardar")
}
                                                

// @LINE:25
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:22
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura")
}
                                                
    
}
                          

// @LINE:74
class ReversePresupuestosReportesController {
    

// @LINE:74
def presupuesto(id:Long, extrajero:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reporte/presupuesto" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(extrajero == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("extrajero", extrajero)))))
}
                                                
    
}
                          

// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
class ReverseRecuperoReportesController {
    

// @LINE:89
def informePlanilla(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "reportesPlanilla/imprimirPlanilla")
}
                                                

// @LINE:76
def informeDeuda(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recupero/reportes/deudas")
}
                                                

// @LINE:77
def informeGeneral(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "recupero/reportes/informeGeneral")
}
                                                

// @LINE:84
def imprimirFactura(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "facturas/imprimir-factura" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:88
def modalPlanilla(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "reportesPlanilla/modalPlanilla")
}
                                                

// @LINE:82
def reporteFacturasExcel(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recupero/reportes/reporteFacturasExcel")
}
                                                

// @LINE:85
def imprimirRecibo(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pagos/imprimir-recibo" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:91
def informeDesdePlanilla(idPlanilla:Long = 0): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "reportesPlanilla/imprimirDesdePlanilla" + queryString(List(if(idPlanilla == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("idPlanilla", idPlanilla)))))
}
                                                

// @LINE:81
def reportePagosExcel(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "recupero/reportes/reportePagosExcel")
}
                                                

// @LINE:78
def archivoInformeDeuda(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "archivo/deudas")
}
                                                

// @LINE:79
def archivoInformeGeneral(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "archivo/archivoInformeGeneral")
}
                                                
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReversePresupuestosController {
    

// @LINE:13
def cambiarEstado(idPresupuesto:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idPresupuesto", idPresupuesto)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:6
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu/crear")
}
                                                

// @LINE:12
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presu/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:10
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:9
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:7
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presu/guardar")
}
                                                

// @LINE:8
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:5
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu")
}
                                                

// @LINE:11
def duplicar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presu/duplicar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                
    
}
                          

// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
class ReverseRecuperoFacturaLineasController {
    

// @LINE:31
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:36
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:34
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea/guardar")
}
                                                

// @LINE:35
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "factura-linea/actualizar")
}
                                                

// @LINE:33
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:32
def crear(facturaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "factura-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("facturaId", facturaId)))))
}
                                                
    
}
                          

// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
class ReverseRecuperoChequesController {
    

// @LINE:60
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/cheque/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:59
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/cheques/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:56
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pago/cheques/guardar")
}
                                                

// @LINE:58
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pago/cheques/actualizar")
}
                                                

// @LINE:57
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/cheques/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:55
def crear(pagoId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/cheques/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("pagoId", pagoId)))))
}
                                                
    
}
                          

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseRecuperoNotasCreditosController {
    

// @LINE:38
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nota-credito-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:43
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nota-credito-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:41
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "nota-credito-linea/guardar")
}
                                                

// @LINE:42
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "nota-credito-linea/actualizar")
}
                                                

// @LINE:40
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nota-credito-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:39
def crear(facturaId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "nota-credito-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("facturaId", facturaId)))))
}
                                                
    
}
                          

// @LINE:4
class ReverseIndexController {
    

// @LINE:4
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
class ReverseRecuperoPagosController {
    

// @LINE:52
def cambiarEstado(idRecuperoPago:Long, idEstado:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/cambiarEstado" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("idRecuperoPago", idRecuperoPago)), Some(implicitly[QueryStringBindable[Long]].unbind("idEstado", idEstado)))))
}
                                                

// @LINE:46
def crear(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/crear")
}
                                                

// @LINE:51
def actualizar(id:Long): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pago/actualizar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:50
def ver(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/ver" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:49
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:47
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "pago/guardar")
}
                                                

// @LINE:53
def crearPagoParcial(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/crearPagoParcial" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:48
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:45
def index(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "pago")
}
                                                
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReversePresupuestoLineasController {
    

// @LINE:15
def index(id:Long = 0, editable:Boolean = false): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto-linea/index" + queryString(List(if(id == 0) None else Some(implicitly[QueryStringBindable[Long]].unbind("id", id)), if(editable == false) None else Some(implicitly[QueryStringBindable[Boolean]].unbind("editable", editable)))))
}
                                                

// @LINE:20
def eliminar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto-linea/eliminar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:18
def guardar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto-linea/guardar")
}
                                                

// @LINE:19
def actualizar(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "presupuesto-linea/actualizar")
}
                                                

// @LINE:17
def editar(id:Long): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto-linea/editar" + queryString(List(Some(implicitly[QueryStringBindable[Long]].unbind("id", id)))))
}
                                                

// @LINE:16
def crear(presupuestoId:String): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "presupuesto-linea/crear" + queryString(List(Some(implicitly[QueryStringBindable[String]].unbind("presupuestoId", presupuestoId)))))
}
                                                
    
}
                          
}
                  


// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:74
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
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
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
package controllers.recupero.javascript {

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
class ReverseRecuperoPlanillasController {
    

// @LINE:72
def suggestRecuperoPlanilla : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.suggestRecuperoPlanilla",
   """
      function(input) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "suggestRecuperoPlanilla/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("input", encodeURIComponent(input))})
      }
   """
)
                        

// @LINE:64
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/crear"})
      }
   """
)
                        

// @LINE:69
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:71
def get : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.get",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/get" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("id", id))])})
      }
   """
)
                        

// @LINE:68
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:67
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:65
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/guardar"})
      }
   """
)
                        

// @LINE:70
def modalBuscar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.modalBuscar",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/modalBuscar"})
      }
   """
)
                        

// @LINE:66
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:63
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPlanillasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "planilla"})
      }
   """
)
                        
    
}
              

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseRecuperoFacturasController {
    

// @LINE:29
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.cambiarEstado",
   """
      function(idRecuperoFactura,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idRecuperoFactura", idRecuperoFactura), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:23
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/crear"})
      }
   """
)
                        

// @LINE:28
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:27
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:26
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:24
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/guardar"})
      }
   """
)
                        

// @LINE:25
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:22
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturasController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura"})
      }
   """
)
                        
    
}
              

// @LINE:74
class ReversePresupuestosReportesController {
    

// @LINE:74
def presupuesto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosReportesController.presupuesto",
   """
      function(id,extrajero) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reporte/presupuesto" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id), (extrajero == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("extrajero", extrajero))])})
      }
   """
)
                        
    
}
              

// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
class ReverseRecuperoReportesController {
    

// @LINE:89
def informePlanilla : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.informePlanilla",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reportesPlanilla/imprimirPlanilla"})
      }
   """
)
                        

// @LINE:76
def informeDeuda : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.informeDeuda",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recupero/reportes/deudas"})
      }
   """
)
                        

// @LINE:77
def informeGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.informeGeneral",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "recupero/reportes/informeGeneral"})
      }
   """
)
                        

// @LINE:84
def imprimirFactura : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.imprimirFactura",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "facturas/imprimir-factura" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:88
def modalPlanilla : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.modalPlanilla",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "reportesPlanilla/modalPlanilla"})
      }
   """
)
                        

// @LINE:82
def reporteFacturasExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.reporteFacturasExcel",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recupero/reportes/reporteFacturasExcel"})
      }
   """
)
                        

// @LINE:85
def imprimirRecibo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.imprimirRecibo",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pagos/imprimir-recibo" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:91
def informeDesdePlanilla : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.informeDesdePlanilla",
   """
      function(idPlanilla) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "reportesPlanilla/imprimirDesdePlanilla" + _qS([(idPlanilla == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPlanilla", idPlanilla))])})
      }
   """
)
                        

// @LINE:81
def reportePagosExcel : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.reportePagosExcel",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "recupero/reportes/reportePagosExcel"})
      }
   """
)
                        

// @LINE:78
def archivoInformeDeuda : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.archivoInformeDeuda",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "archivo/deudas"})
      }
   """
)
                        

// @LINE:79
def archivoInformeGeneral : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoReportesController.archivoInformeGeneral",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "archivo/archivoInformeGeneral"})
      }
   """
)
                        
    
}
              

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReversePresupuestosController {
    

// @LINE:13
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.cambiarEstado",
   """
      function(idPresupuesto,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idPresupuesto", idPresupuesto), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:6
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/crear"})
      }
   """
)
                        

// @LINE:12
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:10
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:9
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:7
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/guardar"})
      }
   """
)
                        

// @LINE:8
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:5
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu"})
      }
   """
)
                        

// @LINE:11
def duplicar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestosController.duplicar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presu/duplicar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        
    
}
              

// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
class ReverseRecuperoFacturaLineasController {
    

// @LINE:31
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturaLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:36
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturaLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:34
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturaLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/guardar"})
      }
   """
)
                        

// @LINE:35
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturaLineasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/actualizar"})
      }
   """
)
                        

// @LINE:33
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturaLineasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:32
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoFacturaLineasController.crear",
   """
      function(facturaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "factura-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("facturaId", facturaId)])})
      }
   """
)
                        
    
}
              

// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
class ReverseRecuperoChequesController {
    

// @LINE:60
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoChequesController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cheque/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:59
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoChequesController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cheques/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:56
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoChequesController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cheques/guardar"})
      }
   """
)
                        

// @LINE:58
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoChequesController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cheques/actualizar"})
      }
   """
)
                        

// @LINE:57
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoChequesController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cheques/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:55
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoChequesController.crear",
   """
      function(pagoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cheques/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("pagoId", pagoId)])})
      }
   """
)
                        
    
}
              

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseRecuperoNotasCreditosController {
    

// @LINE:38
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoNotasCreditosController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nota-credito-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:43
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoNotasCreditosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nota-credito-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:41
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoNotasCreditosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "nota-credito-linea/guardar"})
      }
   """
)
                        

// @LINE:42
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoNotasCreditosController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "nota-credito-linea/actualizar"})
      }
   """
)
                        

// @LINE:40
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoNotasCreditosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nota-credito-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:39
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoNotasCreditosController.crear",
   """
      function(facturaId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "nota-credito-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("facturaId", facturaId)])})
      }
   """
)
                        
    
}
              

// @LINE:4
class ReverseIndexController {
    

// @LINE:4
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
class ReverseRecuperoPagosController {
    

// @LINE:52
def cambiarEstado : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.cambiarEstado",
   """
      function(idRecuperoPago,idEstado) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/cambiarEstado" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idRecuperoPago", idRecuperoPago), (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("idEstado", idEstado)])})
      }
   """
)
                        

// @LINE:46
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.crear",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/crear"})
      }
   """
)
                        

// @LINE:51
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.actualizar",
   """
      function(id) {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/actualizar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:50
def ver : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.ver",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/ver" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:49
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:47
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/guardar"})
      }
   """
)
                        

// @LINE:53
def crearPagoParcial : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.crearPagoParcial",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/crearPagoParcial" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:48
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:45
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.RecuperoPagosController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "pago"})
      }
   """
)
                        
    
}
              

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReversePresupuestoLineasController {
    

// @LINE:15
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestoLineasController.index",
   """
      function(id,editable) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto-linea/index" + _qS([(id == null ? null : (""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)), (editable == null ? null : (""" + implicitly[QueryStringBindable[Boolean]].javascriptUnbind + """)("editable", editable))])})
      }
   """
)
                        

// @LINE:20
def eliminar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestoLineasController.eliminar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto-linea/eliminar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:18
def guardar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestoLineasController.guardar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto-linea/guardar"})
      }
   """
)
                        

// @LINE:19
def actualizar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestoLineasController.actualizar",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto-linea/actualizar"})
      }
   """
)
                        

// @LINE:17
def editar : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestoLineasController.editar",
   """
      function(id) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto-linea/editar" + _qS([(""" + implicitly[QueryStringBindable[Long]].javascriptUnbind + """)("id", id)])})
      }
   """
)
                        

// @LINE:16
def crear : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.recupero.PresupuestoLineasController.crear",
   """
      function(presupuestoId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "presupuesto-linea/crear" + _qS([(""" + implicitly[QueryStringBindable[String]].javascriptUnbind + """)("presupuestoId", presupuestoId)])})
      }
   """
)
                        
    
}
              
}
        


// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
// @LINE:74
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
// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
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
package controllers.recupero.ref {


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
class ReverseRecuperoPlanillasController {
    

// @LINE:72
def suggestRecuperoPlanilla(input:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.suggestRecuperoPlanilla(input), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "suggestRecuperoPlanilla", Seq(classOf[String]), "GET", """""", _prefix + """suggestRecuperoPlanilla/$input<[^/]+>""")
)
                      

// @LINE:64
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.crear(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "crear", Seq(), "GET", """""", _prefix + """planilla/crear""")
)
                      

// @LINE:69
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.actualizar(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """planilla/actualizar""")
)
                      

// @LINE:71
def get(id:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.get(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "get", Seq(classOf[Int]), "GET", """""", _prefix + """planilla/get""")
)
                      

// @LINE:68
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.ver(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """planilla/ver""")
)
                      

// @LINE:67
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """planilla/eliminar""")
)
                      

// @LINE:65
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "guardar", Seq(), "POST", """""", _prefix + """planilla/guardar""")
)
                      

// @LINE:70
def modalBuscar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.modalBuscar(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "modalBuscar", Seq(), "GET", """""", _prefix + """planilla/modalBuscar""")
)
                      

// @LINE:66
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """planilla/editar""")
)
                      

// @LINE:63
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPlanillasController.index(), HandlerDef(this, "controllers.recupero.RecuperoPlanillasController", "index", Seq(), "GET", """""", _prefix + """planilla""")
)
                      
    
}
                          

// @LINE:29
// @LINE:28
// @LINE:27
// @LINE:26
// @LINE:25
// @LINE:24
// @LINE:23
// @LINE:22
class ReverseRecuperoFacturasController {
    

// @LINE:29
def cambiarEstado(idRecuperoFactura:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.cambiarEstado(idRecuperoFactura, idEstado), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """factura/cambiarEstado""")
)
                      

// @LINE:23
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.crear(), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "crear", Seq(), "GET", """""", _prefix + """factura/crear""")
)
                      

// @LINE:28
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.actualizar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """factura/actualizar""")
)
                      

// @LINE:27
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.ver(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """factura/ver""")
)
                      

// @LINE:26
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """factura/eliminar""")
)
                      

// @LINE:24
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "guardar", Seq(), "POST", """""", _prefix + """factura/guardar""")
)
                      

// @LINE:25
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """factura/editar""")
)
                      

// @LINE:22
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturasController.index(), HandlerDef(this, "controllers.recupero.RecuperoFacturasController", "index", Seq(), "GET", """""", _prefix + """factura""")
)
                      
    
}
                          

// @LINE:74
class ReversePresupuestosReportesController {
    

// @LINE:74
def presupuesto(id:Long, extrajero:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosReportesController.presupuesto(id, extrajero), HandlerDef(this, "controllers.recupero.PresupuestosReportesController", "presupuesto", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """reporte/presupuesto""")
)
                      
    
}
                          

// @LINE:91
// @LINE:89
// @LINE:88
// @LINE:85
// @LINE:84
// @LINE:82
// @LINE:81
// @LINE:79
// @LINE:78
// @LINE:77
// @LINE:76
class ReverseRecuperoReportesController {
    

// @LINE:89
def informePlanilla(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.informePlanilla(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informePlanilla", Seq(), "POST", """""", _prefix + """reportesPlanilla/imprimirPlanilla""")
)
                      

// @LINE:76
def informeDeuda(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.informeDeuda(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informeDeuda", Seq(), "GET", """""", _prefix + """recupero/reportes/deudas""")
)
                      

// @LINE:77
def informeGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.informeGeneral(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informeGeneral", Seq(), "GET", """""", _prefix + """recupero/reportes/informeGeneral""")
)
                      

// @LINE:84
def imprimirFactura(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.imprimirFactura(id), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "imprimirFactura", Seq(classOf[Long]), "GET", """""", _prefix + """facturas/imprimir-factura""")
)
                      

// @LINE:88
def modalPlanilla(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.modalPlanilla(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "modalPlanilla", Seq(), "GET", """""", _prefix + """reportesPlanilla/modalPlanilla""")
)
                      

// @LINE:82
def reporteFacturasExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.reporteFacturasExcel(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "reporteFacturasExcel", Seq(), "POST", """""", _prefix + """recupero/reportes/reporteFacturasExcel""")
)
                      

// @LINE:85
def imprimirRecibo(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.imprimirRecibo(id), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "imprimirRecibo", Seq(classOf[Long]), "GET", """""", _prefix + """pagos/imprimir-recibo""")
)
                      

// @LINE:91
def informeDesdePlanilla(idPlanilla:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.informeDesdePlanilla(idPlanilla), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "informeDesdePlanilla", Seq(classOf[Long]), "POST", """""", _prefix + """reportesPlanilla/imprimirDesdePlanilla""")
)
                      

// @LINE:81
def reportePagosExcel(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.reportePagosExcel(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "reportePagosExcel", Seq(), "POST", """""", _prefix + """recupero/reportes/reportePagosExcel""")
)
                      

// @LINE:78
def archivoInformeDeuda(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.archivoInformeDeuda(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "archivoInformeDeuda", Seq(), "GET", """""", _prefix + """archivo/deudas""")
)
                      

// @LINE:79
def archivoInformeGeneral(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoReportesController.archivoInformeGeneral(), HandlerDef(this, "controllers.recupero.RecuperoReportesController", "archivoInformeGeneral", Seq(), "GET", """""", _prefix + """archivo/archivoInformeGeneral""")
)
                      
    
}
                          

// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
// @LINE:5
class ReversePresupuestosController {
    

// @LINE:13
def cambiarEstado(idPresupuesto:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.cambiarEstado(idPresupuesto, idEstado), HandlerDef(this, "controllers.recupero.PresupuestosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """presu/cambiarEstado""")
)
                      

// @LINE:6
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.crear(), HandlerDef(this, "controllers.recupero.PresupuestosController", "crear", Seq(), "GET", """""", _prefix + """presu/crear""")
)
                      

// @LINE:12
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.actualizar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """presu/actualizar""")
)
                      

// @LINE:10
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.ver(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """presu/ver""")
)
                      

// @LINE:9
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.eliminar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """presu/eliminar""")
)
                      

// @LINE:7
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.guardar(), HandlerDef(this, "controllers.recupero.PresupuestosController", "guardar", Seq(), "POST", """""", _prefix + """presu/guardar""")
)
                      

// @LINE:8
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.editar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """presu/editar""")
)
                      

// @LINE:5
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.index(), HandlerDef(this, "controllers.recupero.PresupuestosController", "index", Seq(), "GET", """""", _prefix + """presu""")
)
                      

// @LINE:11
def duplicar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestosController.duplicar(id), HandlerDef(this, "controllers.recupero.PresupuestosController", "duplicar", Seq(classOf[Long]), "GET", """""", _prefix + """presu/duplicar""")
)
                      
    
}
                          

// @LINE:36
// @LINE:35
// @LINE:34
// @LINE:33
// @LINE:32
// @LINE:31
class ReverseRecuperoFacturaLineasController {
    

// @LINE:31
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturaLineasController.index(id, editable), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """factura-linea/index""")
)
                      

// @LINE:36
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturaLineasController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea/eliminar""")
)
                      

// @LINE:34
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturaLineasController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "guardar", Seq(), "POST", """""", _prefix + """factura-linea/guardar""")
)
                      

// @LINE:35
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturaLineasController.actualizar(), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "actualizar", Seq(), "POST", """""", _prefix + """factura-linea/actualizar""")
)
                      

// @LINE:33
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturaLineasController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """factura-linea/editar""")
)
                      

// @LINE:32
def crear(facturaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoFacturaLineasController.crear(facturaId), HandlerDef(this, "controllers.recupero.RecuperoFacturaLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """factura-linea/crear""")
)
                      
    
}
                          

// @LINE:60
// @LINE:59
// @LINE:58
// @LINE:57
// @LINE:56
// @LINE:55
class ReverseRecuperoChequesController {
    

// @LINE:60
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoChequesController.index(id, editable), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """pago/cheque/index""")
)
                      

// @LINE:59
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoChequesController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """pago/cheques/eliminar""")
)
                      

// @LINE:56
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoChequesController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "guardar", Seq(), "POST", """""", _prefix + """pago/cheques/guardar""")
)
                      

// @LINE:58
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoChequesController.actualizar(), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "actualizar", Seq(), "POST", """""", _prefix + """pago/cheques/actualizar""")
)
                      

// @LINE:57
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoChequesController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """pago/cheques/editar""")
)
                      

// @LINE:55
def crear(pagoId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoChequesController.crear(pagoId), HandlerDef(this, "controllers.recupero.RecuperoChequesController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """pago/cheques/crear""")
)
                      
    
}
                          

// @LINE:43
// @LINE:42
// @LINE:41
// @LINE:40
// @LINE:39
// @LINE:38
class ReverseRecuperoNotasCreditosController {
    

// @LINE:38
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoNotasCreditosController.index(id, editable), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """nota-credito-linea/index""")
)
                      

// @LINE:43
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoNotasCreditosController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """nota-credito-linea/eliminar""")
)
                      

// @LINE:41
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoNotasCreditosController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "guardar", Seq(), "POST", """""", _prefix + """nota-credito-linea/guardar""")
)
                      

// @LINE:42
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoNotasCreditosController.actualizar(), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "actualizar", Seq(), "POST", """""", _prefix + """nota-credito-linea/actualizar""")
)
                      

// @LINE:40
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoNotasCreditosController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """nota-credito-linea/editar""")
)
                      

// @LINE:39
def crear(facturaId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoNotasCreditosController.crear(facturaId), HandlerDef(this, "controllers.recupero.RecuperoNotasCreditosController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """nota-credito-linea/crear""")
)
                      
    
}
                          

// @LINE:4
class ReverseIndexController {
    

// @LINE:4
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.IndexController.index(), HandlerDef(this, "controllers.recupero.IndexController", "index", Seq(), "GET", """-----------------------------MODULO RECUPERO ---------------------------------""", _prefix + """""")
)
                      
    
}
                          

// @LINE:53
// @LINE:52
// @LINE:51
// @LINE:50
// @LINE:49
// @LINE:48
// @LINE:47
// @LINE:46
// @LINE:45
class ReverseRecuperoPagosController {
    

// @LINE:52
def cambiarEstado(idRecuperoPago:Long, idEstado:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.cambiarEstado(idRecuperoPago, idEstado), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "cambiarEstado", Seq(classOf[Long], classOf[Long]), "GET", """""", _prefix + """pago/cambiarEstado""")
)
                      

// @LINE:46
def crear(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.crear(), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "crear", Seq(), "GET", """""", _prefix + """pago/crear""")
)
                      

// @LINE:51
def actualizar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.actualizar(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "actualizar", Seq(classOf[Long]), "POST", """""", _prefix + """pago/actualizar""")
)
                      

// @LINE:50
def ver(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.ver(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "ver", Seq(classOf[Long]), "GET", """""", _prefix + """pago/ver""")
)
                      

// @LINE:49
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.eliminar(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """pago/eliminar""")
)
                      

// @LINE:47
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.guardar(), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "guardar", Seq(), "POST", """""", _prefix + """pago/guardar""")
)
                      

// @LINE:53
def crearPagoParcial(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.crearPagoParcial(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "crearPagoParcial", Seq(classOf[Long]), "GET", """""", _prefix + """pago/crearPagoParcial""")
)
                      

// @LINE:48
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.editar(id), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """pago/editar""")
)
                      

// @LINE:45
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.RecuperoPagosController.index(), HandlerDef(this, "controllers.recupero.RecuperoPagosController", "index", Seq(), "GET", """""", _prefix + """pago""")
)
                      
    
}
                          

// @LINE:20
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
class ReversePresupuestoLineasController {
    

// @LINE:15
def index(id:Long, editable:Boolean): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestoLineasController.index(id, editable), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "index", Seq(classOf[Long], classOf[Boolean]), "GET", """""", _prefix + """presupuesto-linea/index""")
)
                      

// @LINE:20
def eliminar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestoLineasController.eliminar(id), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "eliminar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto-linea/eliminar""")
)
                      

// @LINE:18
def guardar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestoLineasController.guardar(), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "guardar", Seq(), "POST", """""", _prefix + """presupuesto-linea/guardar""")
)
                      

// @LINE:19
def actualizar(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestoLineasController.actualizar(), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "actualizar", Seq(), "POST", """""", _prefix + """presupuesto-linea/actualizar""")
)
                      

// @LINE:17
def editar(id:Long): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestoLineasController.editar(id), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "editar", Seq(classOf[Long]), "GET", """""", _prefix + """presupuesto-linea/editar""")
)
                      

// @LINE:16
def crear(presupuestoId:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.recupero.PresupuestoLineasController.crear(presupuestoId), HandlerDef(this, "controllers.recupero.PresupuestoLineasController", "crear", Seq(classOf[String]), "GET", """""", _prefix + """presupuesto-linea/crear""")
)
                      
    
}
                          
}
        
    