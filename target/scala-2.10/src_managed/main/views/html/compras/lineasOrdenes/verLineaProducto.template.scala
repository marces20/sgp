
package views.html.compras.lineasOrdenes

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
object verLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[OrdenLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  OrdenLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.22*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasOrdenes.lineaProducto(linea, true))))}
    }
    
    def render(linea:OrdenLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((OrdenLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasOrdenes/verLineaProducto.scala.html
                    HASH: dbfad867517bd71e5d6f96652bf1f6205afee7c4
                    MATRIX: 811->1|925->21|964->26|976->31
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            