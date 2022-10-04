
package views.html.recupero.recuperoNotaCredito

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
object crearLineaNotaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoNotaCredito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[models.recupero.RecuperoNotaCredito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.recupero.routes.RecuperoNotasCreditosController.guardar())/*5.93*/ {_display_(Seq[Any](format.raw/*5.95*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.recupero.recuperoNotaCredito.formLineaNotaCredito(lineaForm))),format.raw/*6.74*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[models.recupero.RecuperoNotaCredito]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[models.recupero.RecuperoNotaCredito]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoNotaCredito/crearLineaNotaCredito.scala.html
                    HASH: b5700f0f53c9be64dc2b6c99a6183eeba527e367
                    MATRIX: 854->1|1011->76|1043->100|1117->55|1146->144|1186->150|1199->156|1292->241|1331->243|1369->247|1381->252|1468->318
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            