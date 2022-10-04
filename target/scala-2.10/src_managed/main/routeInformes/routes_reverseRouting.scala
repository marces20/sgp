// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeInformes.routes
// @HASH:dc3976cc9c53bbdb682bf9e05e43d6e6997dd092
// @DATE:Tue Oct 04 11:43:28 ART 2022

import routeInformes.Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.j._

import play.api.mvc._
import play.libs.F

import Router.queryString


// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
// @LINE:4
// @LINE:3
// @LINE:2
package controllers.informes {

// @LINE:7
// @LINE:6
class ReverseInformesObligacionController {
    

// @LINE:7
def getObligaciones(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "obligaciones/getObligaciones")
}
                                                

// @LINE:6
def obligacion(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "obligaciones")
}
                                                
    
}
                          

// @LINE:17
class ReverseInformesDeudasController {
    

// @LINE:17
def deudasFotoPorFecha(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "deuda/deudasFotoPorFecha")
}
                                                
    
}
                          

// @LINE:2
class ReverseIndexController {
    

// @LINE:2
def index(): Call = {
   Call("GET", _prefix)
}
                                                
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseInformesHonorariosController {
    

// @LINE:11
def getCostoPorTipoConcepto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getCostoPorTipoConcepto")
}
                                                

// @LINE:14
def honorarioRrhhPorPeriodo(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorario/RrhhPorPeriodo")
}
                                                

// @LINE:15
def getCountRrrhPorEscala(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getCountRrrhPorEscala")
}
                                                

// @LINE:10
def getCostoPorEscala(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getCostoPorEscala")
}
                                                

// @LINE:12
def getCostoPorClasificacionConcepto(): Call = {
   Call("POST", _prefix + { _defaultPrefix } + "honorarios/getCostoPorClasificacionConcepto")
}
                                                

// @LINE:9
def honorario(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "honorarios")
}
                                                
    
}
                          

// @LINE:4
// @LINE:3
class ReverseInformesPresupuestoController {
    

// @LINE:3
def creditos(lugarId:Int): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "creditosPresup" + queryString(List(Some(implicitly[QueryStringBindable[Int]].unbind("lugarId", lugarId)))))
}
                                                

// @LINE:4
def getDatosInformesCreditosPresupuestarios(): Call = {
   Call("GET", _prefix + { _defaultPrefix } + "getDatosInformesCreditosPresupuestarios")
}
                                                
    
}
                          
}
                  


// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
// @LINE:4
// @LINE:3
// @LINE:2
package controllers.informes.javascript {

// @LINE:7
// @LINE:6
class ReverseInformesObligacionController {
    

// @LINE:7
def getObligaciones : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesObligacionController.getObligaciones",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "obligaciones/getObligaciones"})
      }
   """
)
                        

// @LINE:6
def obligacion : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesObligacionController.obligacion",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "obligaciones"})
      }
   """
)
                        
    
}
              

// @LINE:17
class ReverseInformesDeudasController {
    

// @LINE:17
def deudasFotoPorFecha : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesDeudasController.deudasFotoPorFecha",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "deuda/deudasFotoPorFecha"})
      }
   """
)
                        
    
}
              

// @LINE:2
class ReverseIndexController {
    

// @LINE:2
def index : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.IndexController.index",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + """"})
      }
   """
)
                        
    
}
              

// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseInformesHonorariosController {
    

// @LINE:11
def getCostoPorTipoConcepto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesHonorariosController.getCostoPorTipoConcepto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getCostoPorTipoConcepto"})
      }
   """
)
                        

// @LINE:14
def honorarioRrhhPorPeriodo : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesHonorariosController.honorarioRrhhPorPeriodo",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorario/RrhhPorPeriodo"})
      }
   """
)
                        

// @LINE:15
def getCountRrrhPorEscala : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesHonorariosController.getCountRrrhPorEscala",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getCountRrrhPorEscala"})
      }
   """
)
                        

// @LINE:10
def getCostoPorEscala : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesHonorariosController.getCostoPorEscala",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getCostoPorEscala"})
      }
   """
)
                        

// @LINE:12
def getCostoPorClasificacionConcepto : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesHonorariosController.getCostoPorClasificacionConcepto",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios/getCostoPorClasificacionConcepto"})
      }
   """
)
                        

// @LINE:9
def honorario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesHonorariosController.honorario",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "honorarios"})
      }
   """
)
                        
    
}
              

// @LINE:4
// @LINE:3
class ReverseInformesPresupuestoController {
    

// @LINE:3
def creditos : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesPresupuestoController.creditos",
   """
      function(lugarId) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "creditosPresup" + _qS([(""" + implicitly[QueryStringBindable[Int]].javascriptUnbind + """)("lugarId", lugarId)])})
      }
   """
)
                        

// @LINE:4
def getDatosInformesCreditosPresupuestarios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.informes.InformesPresupuestoController.getDatosInformesCreditosPresupuestarios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getDatosInformesCreditosPresupuestarios"})
      }
   """
)
                        
    
}
              
}
        


// @LINE:17
// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:7
// @LINE:6
// @LINE:4
// @LINE:3
// @LINE:2
package controllers.informes.ref {


// @LINE:7
// @LINE:6
class ReverseInformesObligacionController {
    

// @LINE:7
def getObligaciones(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesObligacionController.getObligaciones(), HandlerDef(this, "controllers.informes.InformesObligacionController", "getObligaciones", Seq(), "POST", """""", _prefix + """obligaciones/getObligaciones""")
)
                      

// @LINE:6
def obligacion(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesObligacionController.obligacion(), HandlerDef(this, "controllers.informes.InformesObligacionController", "obligacion", Seq(), "GET", """""", _prefix + """obligaciones""")
)
                      
    
}
                          

// @LINE:17
class ReverseInformesDeudasController {
    

// @LINE:17
def deudasFotoPorFecha(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesDeudasController.deudasFotoPorFecha(), HandlerDef(this, "controllers.informes.InformesDeudasController", "deudasFotoPorFecha", Seq(), "GET", """""", _prefix + """deuda/deudasFotoPorFecha""")
)
                      
    
}
                          

// @LINE:2
class ReverseIndexController {
    

// @LINE:2
def index(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.IndexController.index(), HandlerDef(this, "controllers.informes.IndexController", "index", Seq(), "GET", """""", _prefix + """""")
)
                      
    
}
                          

// @LINE:15
// @LINE:14
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
class ReverseInformesHonorariosController {
    

// @LINE:11
def getCostoPorTipoConcepto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesHonorariosController.getCostoPorTipoConcepto(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCostoPorTipoConcepto", Seq(), "POST", """""", _prefix + """honorarios/getCostoPorTipoConcepto""")
)
                      

// @LINE:14
def honorarioRrhhPorPeriodo(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesHonorariosController.honorarioRrhhPorPeriodo(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "honorarioRrhhPorPeriodo", Seq(), "GET", """""", _prefix + """honorario/RrhhPorPeriodo""")
)
                      

// @LINE:15
def getCountRrrhPorEscala(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesHonorariosController.getCountRrrhPorEscala(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCountRrrhPorEscala", Seq(), "POST", """""", _prefix + """honorarios/getCountRrrhPorEscala""")
)
                      

// @LINE:10
def getCostoPorEscala(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesHonorariosController.getCostoPorEscala(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCostoPorEscala", Seq(), "POST", """""", _prefix + """honorarios/getCostoPorEscala""")
)
                      

// @LINE:12
def getCostoPorClasificacionConcepto(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesHonorariosController.getCostoPorClasificacionConcepto(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCostoPorClasificacionConcepto", Seq(), "POST", """""", _prefix + """honorarios/getCostoPorClasificacionConcepto""")
)
                      

// @LINE:9
def honorario(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesHonorariosController.honorario(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "honorario", Seq(), "GET", """""", _prefix + """honorarios""")
)
                      
    
}
                          

// @LINE:4
// @LINE:3
class ReverseInformesPresupuestoController {
    

// @LINE:3
def creditos(lugarId:Int): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesPresupuestoController.creditos(lugarId), HandlerDef(this, "controllers.informes.InformesPresupuestoController", "creditos", Seq(classOf[Int]), "GET", """""", _prefix + """creditosPresup""")
)
                      

// @LINE:4
def getDatosInformesCreditosPresupuestarios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.informes.InformesPresupuestoController.getDatosInformesCreditosPresupuestarios(), HandlerDef(this, "controllers.informes.InformesPresupuestoController", "getDatosInformesCreditosPresupuestarios", Seq(), "GET", """""", _prefix + """getDatosInformesCreditosPresupuestarios""")
)
                      
    
}
                          
}
        
    