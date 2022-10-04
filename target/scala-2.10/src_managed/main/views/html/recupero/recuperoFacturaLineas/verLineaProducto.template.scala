
package views.html.recupero.recuperoFacturaLineas

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
object verLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.recupero.RecuperoFacturaLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  models.recupero.RecuperoFacturaLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.48*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.recupero.recuperoFacturaLineas.lineaProducto(linea, true))))}
    }
    
    def render(linea:models.recupero.RecuperoFacturaLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((models.recupero.RecuperoFacturaLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoFacturaLineas/verLineaProducto.scala.html
                    HASH: 366949ae610e47a97d4b23af98c6821d09550f57
                    MATRIX: 846->1|986->47|1025->52|1037->57
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            