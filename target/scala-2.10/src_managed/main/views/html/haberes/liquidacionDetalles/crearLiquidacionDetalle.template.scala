
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
object crearLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[Form[models.haberes.LiquidacionDetalle],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(detalleForm: Form[models.haberes.LiquidacionDetalle]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._

implicit def /*3.2*/implicitFieldConstructor/*3.26*/ = {{ FieldConstructor(simpleInput.render) }};
Seq[Any](format.raw/*1.56*/("""
"""),format.raw/*3.70*/(""" 

"""),_display_(Seq[Any](/*5.2*/helper/*5.8*/.form(action = controllers.haberes.routes.LiquidacionDetallesController.guardar())/*5.90*/ {_display_(Seq[Any](format.raw/*5.92*/("""
	"""),_display_(Seq[Any](/*6.3*/views/*6.8*/.html.haberes.liquidacionDetalles.formLiquidacionDetalle(detalleForm))),format.raw/*6.77*/("""
	 
""")))})))}
    }
    
    def render(detalleForm:Form[models.haberes.LiquidacionDetalle]): play.api.templates.HtmlFormat.Appendable = apply(detalleForm)
    
    def f:((Form[models.haberes.LiquidacionDetalle]) => play.api.templates.HtmlFormat.Appendable) = (detalleForm) => apply(detalleForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/crearLiquidacionDetalle.scala.html
                    HASH: aecab3c05141a9073a843b97937b6dff8f4cf7bc
                    MATRIX: 853->1|1010->76|1042->100|1116->55|1145->144|1185->150|1198->156|1288->238|1327->240|1365->244|1377->249|1467->318
                    LINES: 26->1|29->3|29->3|30->1|31->3|33->5|33->5|33->5|33->5|34->6|34->6|34->6
                    -- GENERATED --
                */
            