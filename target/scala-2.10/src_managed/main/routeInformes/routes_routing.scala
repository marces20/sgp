// @SOURCE:/home/marce/hspwork/play/sgpgit/sgp/conf/routeInformes.routes
// @HASH:dc3976cc9c53bbdb682bf9e05e43d6e6997dd092
// @DATE:Tue Oct 04 11:43:28 ART 2022
package routeInformes

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


// @LINE:2
private[this] lazy val controllers_informes_IndexController_index0 = Route("GET", PathPattern(List(StaticPart(Routes.prefix))))
        

// @LINE:3
private[this] lazy val controllers_informes_InformesPresupuestoController_creditos1 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("creditosPresup"))))
        

// @LINE:4
private[this] lazy val controllers_informes_InformesPresupuestoController_getDatosInformesCreditosPresupuestarios2 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("getDatosInformesCreditosPresupuestarios"))))
        

// @LINE:6
private[this] lazy val controllers_informes_InformesObligacionController_obligacion3 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("obligaciones"))))
        

// @LINE:7
private[this] lazy val controllers_informes_InformesObligacionController_getObligaciones4 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("obligaciones/getObligaciones"))))
        

// @LINE:9
private[this] lazy val controllers_informes_InformesHonorariosController_honorario5 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios"))))
        

// @LINE:10
private[this] lazy val controllers_informes_InformesHonorariosController_getCostoPorEscala6 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getCostoPorEscala"))))
        

// @LINE:11
private[this] lazy val controllers_informes_InformesHonorariosController_getCostoPorTipoConcepto7 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getCostoPorTipoConcepto"))))
        

// @LINE:12
private[this] lazy val controllers_informes_InformesHonorariosController_getCostoPorClasificacionConcepto8 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getCostoPorClasificacionConcepto"))))
        

// @LINE:14
private[this] lazy val controllers_informes_InformesHonorariosController_honorarioRrhhPorPeriodo9 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorario/RrhhPorPeriodo"))))
        

// @LINE:15
private[this] lazy val controllers_informes_InformesHonorariosController_getCountRrrhPorEscala10 = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("honorarios/getCountRrrhPorEscala"))))
        

// @LINE:17
private[this] lazy val controllers_informes_InformesDeudasController_deudasFotoPorFecha11 = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("deuda/deudasFotoPorFecha"))))
        
def documentation = List(("""GET""", prefix,"""controllers.informes.IndexController.index()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """creditosPresup""","""controllers.informes.InformesPresupuestoController.creditos(lugarId:Int)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """getDatosInformesCreditosPresupuestarios""","""controllers.informes.InformesPresupuestoController.getDatosInformesCreditosPresupuestarios()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """obligaciones""","""controllers.informes.InformesObligacionController.obligacion()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """obligaciones/getObligaciones""","""controllers.informes.InformesObligacionController.getObligaciones()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios""","""controllers.informes.InformesHonorariosController.honorario()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getCostoPorEscala""","""controllers.informes.InformesHonorariosController.getCostoPorEscala()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getCostoPorTipoConcepto""","""controllers.informes.InformesHonorariosController.getCostoPorTipoConcepto()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getCostoPorClasificacionConcepto""","""controllers.informes.InformesHonorariosController.getCostoPorClasificacionConcepto()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorario/RrhhPorPeriodo""","""controllers.informes.InformesHonorariosController.honorarioRrhhPorPeriodo()"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """honorarios/getCountRrrhPorEscala""","""controllers.informes.InformesHonorariosController.getCountRrrhPorEscala()"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """deuda/deudasFotoPorFecha""","""controllers.informes.InformesDeudasController.deudasFotoPorFecha()""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]] 
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:2
case controllers_informes_IndexController_index0(params) => {
   call { 
        invokeHandler(controllers.informes.IndexController.index(), HandlerDef(this, "controllers.informes.IndexController", "index", Nil,"GET", """""", Routes.prefix + """"""))
   }
}
        

// @LINE:3
case controllers_informes_InformesPresupuestoController_creditos1(params) => {
   call(params.fromQuery[Int]("lugarId", None)) { (lugarId) =>
        invokeHandler(controllers.informes.InformesPresupuestoController.creditos(lugarId), HandlerDef(this, "controllers.informes.InformesPresupuestoController", "creditos", Seq(classOf[Int]),"GET", """""", Routes.prefix + """creditosPresup"""))
   }
}
        

// @LINE:4
case controllers_informes_InformesPresupuestoController_getDatosInformesCreditosPresupuestarios2(params) => {
   call { 
        invokeHandler(controllers.informes.InformesPresupuestoController.getDatosInformesCreditosPresupuestarios(), HandlerDef(this, "controllers.informes.InformesPresupuestoController", "getDatosInformesCreditosPresupuestarios", Nil,"GET", """""", Routes.prefix + """getDatosInformesCreditosPresupuestarios"""))
   }
}
        

// @LINE:6
case controllers_informes_InformesObligacionController_obligacion3(params) => {
   call { 
        invokeHandler(controllers.informes.InformesObligacionController.obligacion(), HandlerDef(this, "controllers.informes.InformesObligacionController", "obligacion", Nil,"GET", """""", Routes.prefix + """obligaciones"""))
   }
}
        

// @LINE:7
case controllers_informes_InformesObligacionController_getObligaciones4(params) => {
   call { 
        invokeHandler(controllers.informes.InformesObligacionController.getObligaciones(), HandlerDef(this, "controllers.informes.InformesObligacionController", "getObligaciones", Nil,"POST", """""", Routes.prefix + """obligaciones/getObligaciones"""))
   }
}
        

// @LINE:9
case controllers_informes_InformesHonorariosController_honorario5(params) => {
   call { 
        invokeHandler(controllers.informes.InformesHonorariosController.honorario(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "honorario", Nil,"GET", """""", Routes.prefix + """honorarios"""))
   }
}
        

// @LINE:10
case controllers_informes_InformesHonorariosController_getCostoPorEscala6(params) => {
   call { 
        invokeHandler(controllers.informes.InformesHonorariosController.getCostoPorEscala(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCostoPorEscala", Nil,"POST", """""", Routes.prefix + """honorarios/getCostoPorEscala"""))
   }
}
        

// @LINE:11
case controllers_informes_InformesHonorariosController_getCostoPorTipoConcepto7(params) => {
   call { 
        invokeHandler(controllers.informes.InformesHonorariosController.getCostoPorTipoConcepto(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCostoPorTipoConcepto", Nil,"POST", """""", Routes.prefix + """honorarios/getCostoPorTipoConcepto"""))
   }
}
        

// @LINE:12
case controllers_informes_InformesHonorariosController_getCostoPorClasificacionConcepto8(params) => {
   call { 
        invokeHandler(controllers.informes.InformesHonorariosController.getCostoPorClasificacionConcepto(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCostoPorClasificacionConcepto", Nil,"POST", """""", Routes.prefix + """honorarios/getCostoPorClasificacionConcepto"""))
   }
}
        

// @LINE:14
case controllers_informes_InformesHonorariosController_honorarioRrhhPorPeriodo9(params) => {
   call { 
        invokeHandler(controllers.informes.InformesHonorariosController.honorarioRrhhPorPeriodo(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "honorarioRrhhPorPeriodo", Nil,"GET", """""", Routes.prefix + """honorario/RrhhPorPeriodo"""))
   }
}
        

// @LINE:15
case controllers_informes_InformesHonorariosController_getCountRrrhPorEscala10(params) => {
   call { 
        invokeHandler(controllers.informes.InformesHonorariosController.getCountRrrhPorEscala(), HandlerDef(this, "controllers.informes.InformesHonorariosController", "getCountRrrhPorEscala", Nil,"POST", """""", Routes.prefix + """honorarios/getCountRrrhPorEscala"""))
   }
}
        

// @LINE:17
case controllers_informes_InformesDeudasController_deudasFotoPorFecha11(params) => {
   call { 
        invokeHandler(controllers.informes.InformesDeudasController.deudasFotoPorFecha(), HandlerDef(this, "controllers.informes.InformesDeudasController", "deudasFotoPorFecha", Nil,"GET", """""", Routes.prefix + """deuda/deudasFotoPorFecha"""))
   }
}
        
}

}
     