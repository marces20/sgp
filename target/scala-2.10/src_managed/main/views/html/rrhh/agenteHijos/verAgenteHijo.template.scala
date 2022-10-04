
package views.html.rrhh.agenteHijos

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
object verAgenteHijo extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[AgenteHijo,Boolean,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  AgenteHijo, editable: Boolean):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.41*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.rrhh.agenteHijos.lineaAgenteHijo(linea, editable))))}
    }
    
    def render(linea:AgenteHijo,editable:Boolean): play.api.templates.HtmlFormat.Appendable = apply(linea,editable)
    
    def f:((AgenteHijo,Boolean) => play.api.templates.HtmlFormat.Appendable) = (linea,editable) => apply(linea,editable)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:30 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/rrhh/agenteHijos/verAgenteHijo.scala.html
                    HASH: b65224f38e4a3e2d9c0d4c232c0095a2cd63185c
                    MATRIX: 811->1|944->40|983->45|995->50
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            