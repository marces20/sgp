
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
object editarExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[ExpedienteMovimiento],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[ExpedienteMovimiento]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.41*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.expediente.routes.ExpedientesMovimientosController.actualizar())/*5.99*/ {_display_(Seq[Any](format.raw/*5.101*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.expediente.expedientesMovimientos.formExpedienteMovimiento(lineaForm))),format.raw/*6.83*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[ExpedienteMovimiento]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[ExpedienteMovimiento]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedientesMovimientos/editarExpedienteMovimiento.scala.html
                    HASH: 7e67c25418c544045a8bec82e85f2a1cb9fe7713
                    MATRIX: 849->1|991->61|1023->85|1097->40|1126->129|1166->135|1179->141|1278->232|1318->234|1356->238|1368->243|1464->318|1502->322|1570->369
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            