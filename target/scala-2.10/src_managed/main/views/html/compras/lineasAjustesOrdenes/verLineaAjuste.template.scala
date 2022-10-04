
package views.html.compras.lineasAjustesOrdenes

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
object verLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[OrdenLineaAjuste,Orden,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  OrdenLineaAjuste,o:Orden):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasAjustesOrdenes.lineaAjuste(linea, true))))}
    }
    
    def render(linea:OrdenLineaAjuste,o:Orden): play.api.templates.HtmlFormat.Appendable = apply(linea,o)
    
    def f:((OrdenLineaAjuste,Orden) => play.api.templates.HtmlFormat.Appendable) = (linea,o) => apply(linea,o)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:45 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasAjustesOrdenes/verLineaAjuste.scala.html
                    HASH: 36919d7e216aebbbc061f7934c8d60accb2a6674
                    MATRIX: 828->1|956->35|995->40|1007->45
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            