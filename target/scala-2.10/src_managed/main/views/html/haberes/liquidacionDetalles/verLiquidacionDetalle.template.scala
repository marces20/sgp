
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
object verLiquidacionDetalle extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.haberes.LiquidacionDetalle,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(detalle:  models.haberes.LiquidacionDetalle):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.47*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.haberes.liquidacionDetalles.lineaLiquidacionDetalle(detalle, true))))}
    }
    
    def render(detalle:models.haberes.LiquidacionDetalle): play.api.templates.HtmlFormat.Appendable = apply(detalle)
    
    def f:((models.haberes.LiquidacionDetalle) => play.api.templates.HtmlFormat.Appendable) = (detalle) => apply(detalle)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:34 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/haberes/liquidacionDetalles/verLiquidacionDetalle.scala.html
                    HASH: 436cc9c82a5b35ad6b0bb65ab10d6cb52df0cde1
                    MATRIX: 845->1|984->46|1023->51|1035->56
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            