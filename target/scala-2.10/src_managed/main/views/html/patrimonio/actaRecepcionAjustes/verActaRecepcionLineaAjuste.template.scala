
package views.html.patrimonio.actaRecepcionAjustes

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
object verActaRecepcionLineaAjuste extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[ActaRecepcionLineaAjuste,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  ActaRecepcionLineaAjuste):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.36*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.patrimonio.actaRecepcionAjustes.lineaActaRecepcionLineaAjuste(linea, true))))}
    }
    
    def render(linea:ActaRecepcionLineaAjuste): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((ActaRecepcionLineaAjuste) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:33 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/patrimonio/actaRecepcionAjustes/verActaRecepcionLineaAjuste.scala.html
                    HASH: 8504d5488ae357a296255a80f6910e6c5dcda119
                    MATRIX: 846->1|974->35|1013->40|1025->45
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            