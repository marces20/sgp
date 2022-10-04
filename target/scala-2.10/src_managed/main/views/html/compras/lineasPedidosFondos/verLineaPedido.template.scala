
package views.html.compras.lineasPedidosFondos

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
object verLineaPedido extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[PedidoFondoLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  PedidoFondoLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.28*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasPedidosFondos.lineaPedido(linea, true))))}
    }
    
    def render(linea:PedidoFondoLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((PedidoFondoLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:44 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasPedidosFondos/verLineaPedido.scala.html
                    HASH: f97a4b0e15eebb32bccf7477596f46999c99b4e9
                    MATRIX: 821->1|941->27|980->32|992->37
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            