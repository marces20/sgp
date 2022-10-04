
package views.html.patrimonio.actasMovimientos

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
object verActaMovimiento extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[ActaMovimiento,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  ActaMovimiento):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.26*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.patrimonio.actasMovimientos.lineaActaMovimiento(linea, true))))}
    }
    
    def render(linea:ActaMovimiento): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((ActaMovimiento) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:32 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actasMovimientos/verActaMovimiento.scala.html
                    HASH: f486d911c2a4e048eec9659446b67b0aa3f3bd26
                    MATRIX: 822->1|940->25|979->30|991->35
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            