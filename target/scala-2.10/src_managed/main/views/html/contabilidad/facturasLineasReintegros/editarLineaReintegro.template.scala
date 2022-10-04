
package views.html.contabilidad.facturasLineasReintegros

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
object editarLineaReintegro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[FacturaLineaReintegro],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(lineaForm: Form[FacturaLineaReintegro]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.42*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.contabilidad.routes.FacturasLineasReintegrosController.actualizar())/*5.103*/ {_display_(Seq[Any](format.raw/*5.105*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.contabilidad.facturasLineasReintegros.formLineaReintegro(lineaForm))),format.raw/*6.81*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(lineaForm("id"), 'hidden -> "hidden"))),format.raw/*7.50*/("""
""")))})))}
    }
    
    def render(lineaForm:Form[FacturaLineaReintegro]): play.api.templates.HtmlFormat.Appendable = apply(lineaForm)
    
    def f:((Form[FacturaLineaReintegro]) => play.api.templates.HtmlFormat.Appendable) = (lineaForm) => apply(lineaForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:38 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/contabilidad/facturasLineasReintegros/editarLineaReintegro.scala.html
                    HASH: 722f640fe69946322f625ccd052d0bd26c73c807
                    MATRIX: 848->1|991->62|1023->86|1097->41|1126->130|1166->136|1179->142|1283->237|1323->239|1361->243|1373->248|1467->321|1505->325|1573->372
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            