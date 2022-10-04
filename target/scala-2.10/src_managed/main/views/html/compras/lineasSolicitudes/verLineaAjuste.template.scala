
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
object verLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[SolicitudLineaAjuste,Solicitud,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  SolicitudLineaAjuste,solicitud: Solicitud):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.53*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.compras.lineasSolicitudes.lineaAjuste(linea, true, solicitud))))}
    }
    
    def render(linea:SolicitudLineaAjuste,solicitud:Solicitud): play.api.templates.HtmlFormat.Appendable = apply(linea,solicitud)
    
    def f:((SolicitudLineaAjuste,Solicitud) => play.api.templates.HtmlFormat.Appendable) = (linea,solicitud) => apply(linea,solicitud)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:43 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/lineasSolicitudes/verLineaAjuste.scala.html
                    HASH: 55ea603dd94e9d5f4faa311e401b0d913353f71a
                    MATRIX: 833->1|978->52|1015->55|1027->60
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            