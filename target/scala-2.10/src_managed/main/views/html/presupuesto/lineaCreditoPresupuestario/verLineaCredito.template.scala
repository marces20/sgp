
package views.html.presupuesto.lineaCreditoPresupuestario

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
object verLineaCredito extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[LineaCreditoPresupuestario,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  LineaCreditoPresupuestario):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.38*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.presupuesto.lineaCreditoPresupuestario.lineaCredito(linea, true))))}
    }
    
    def render(linea:LineaCreditoPresupuestario): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((LineaCreditoPresupuestario) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaCreditoPresupuestario/verLineaCredito.scala.html
                    HASH: 53b4133bf2ac72bf7aba8add962f328c95d009b5
                    MATRIX: 843->1|973->37|1012->42|1024->47
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            