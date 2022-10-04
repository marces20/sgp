
package views.html.haberes.liquidacionDetalles

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
object editarLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionDetalle],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(detalleForm: Form[models.haberes.LiquidacionDetalle]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.haberes.routes.LiquidacionDetallesController.actualizar())/*5.93*/ {_display_(Seq[Any](format.raw/*5.95*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.haberes.liquidacionDetalles.formLiquidacionDetalle(detalleForm))),format.raw/*6.77*/("""
	"""),_display_(Seq[Any](/*7.3*/inputText(detalleForm("id"), 'hidden -> "hidden"))),format.raw/*7.52*/("""
	
""")))})))}
    }
    
    def render(detalleForm:Form[models.haberes.LiquidacionDetalle]): play.api.templates.HtmlFormat.Appendable = apply(detalleForm)
    
    def f:((Form[models.haberes.LiquidacionDetalle]) => play.api.templates.HtmlFormat.Appendable) = (detalleForm) => apply(detalleForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/editarLiquidacionDetalle.scala.html
                    HASH: 7cdce37fefbb34de3bae32e8a26771df053b9775
                    MATRIX: 854->1|1011->76|1043->100|1117->55|1146->144|1186->150|1199->156|1292->241|1331->243|1369->247|1381->252|1471->321|1509->325|1579->374
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6|35->7|35->7
                    -- GENERATED --
                */
            