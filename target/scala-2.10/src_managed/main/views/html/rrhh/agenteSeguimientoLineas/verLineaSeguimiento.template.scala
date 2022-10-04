
package views.html.rrhh.agenteSeguimientoLineas

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
object verLineaSeguimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[AgenteSeguimientoLinea,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  AgenteSeguimientoLinea):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.34*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.rrhh.agenteSeguimientoLineas.lineaSeguimiento(linea, true))))}
    }
    
    def render(linea:AgenteSeguimientoLinea): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((AgenteSeguimientoLinea) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:31 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteSeguimientoLineas/verLineaSeguimiento.scala.html
                    HASH: d174cc7abdfabee77e0b58d787dd5b1c56af16b2
                    MATRIX: 833->1|959->33|996->36|1008->41
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            