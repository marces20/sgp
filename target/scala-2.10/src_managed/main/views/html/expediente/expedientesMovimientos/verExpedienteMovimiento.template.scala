
package views.html.expediente.expedientesMovimientos

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
object verExpedienteMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[ExpedienteMovimiento,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  ExpedienteMovimiento):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.expediente.expedientesMovimientos.lineaExpedienteMovimiento(linea, true))))}
    }
    
    def render(linea:ExpedienteMovimiento): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((ExpedienteMovimiento) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:36 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/expediente/expedientesMovimientos/verExpedienteMovimiento.scala.html
                    HASH: 0632812b6c336909732db41f037c13ba2f4ca524
                    MATRIX: 840->1|964->31|1003->36|1015->41
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            