
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
object editarLineaNotaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.recupero.RecuperoNotaCredito],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[models.recupero.RecuperoNotaCredito]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.recupero.routes.RecuperoNotasCreditosController.actualizar())/*5.96*/ {_display_(Seq[Any](format.raw/*5.98*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.recupero.recuperoNotaCredito.formLineaNotaCredito(lineaForm))),format.raw/*6.74*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
	
""")))})))}
    }
    
    def render(lineaForm:Form[models.recupero.RecuperoNotaCredito]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[models.recupero.RecuperoNotaCredito]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoNotaCredito/editarLineaNotaCredito.scala.html
                    HASH: b8827e80e7c90116133160e6d2f50834799b01ab
                    MATRIX: 855->1|1012->76|1044->100|1118->55|1147->144|1187->150|1200->156|1296->244|1335->246|1373->250|1385->255|1472->321|1510->325|1578->372
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            