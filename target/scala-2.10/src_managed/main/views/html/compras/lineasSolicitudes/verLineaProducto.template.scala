
package views.html.compras.lineasSolicitudes

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
object verLineaProducto extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[SolicitudLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  SolicitudLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasSolicitudes.lineaProducto(linea, true,false))))}
    }
    
    def render(linea:SolicitudLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((SolicitudLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/verLineaProducto.scala.html
                    HASH: 6cf92005e45a2ec80c8c91c6272830876c712fc8
                    MATRIX: 819->1|937->25|976->30|988->35
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            