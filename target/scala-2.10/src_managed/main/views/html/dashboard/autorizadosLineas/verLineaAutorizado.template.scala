
package views.html.dashboard.autorizadosLineas

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
object verLineaAutorizado extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[AutorizadoLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  AutorizadoLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.27*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.dashboard.autorizadosLineas.lineaAutorizado(linea, true))))}
    }
    
    def render(linea:AutorizadoLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((AutorizadoLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:56 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/dashboard/autorizadosLineas/verLineaAutorizado.scala.html
                    HASH: f0506debd3d569b02f6bdb6cc4c36c5386adf0a5
                    MATRIX: 824->1|943->26|982->31|994->36
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            