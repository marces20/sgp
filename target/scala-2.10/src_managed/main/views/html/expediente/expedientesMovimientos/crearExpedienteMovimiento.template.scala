
package views.html.expediente.expedientesMovimientos

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object crearExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ExpedienteMovimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ExpedienteMovimiento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.expediente.routes.ExpedientesMovimientosController.guardar())/*5.96*/ {_display_(Seq[Any](format.raw/*5.98*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.expediente.expedientesMovimientos.formExpedienteMovimiento(lineaForm))),format.raw/*6.83*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[ExpedienteMovimiento]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[ExpedienteMovimiento]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedientesMovimientos/crearExpedienteMovimiento.scala.html
                    HASH: cee98633e794c3234abc5ae0f10ac05f90d0cd41
                    MATRIX: 848->1|990->61|1022->85|1096->40|1125->129|1165->135|1178->141|1274->229|1313->231|1351->235|1363->240|1459->315
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            