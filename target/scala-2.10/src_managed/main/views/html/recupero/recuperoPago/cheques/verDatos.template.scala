
package views.html.recupero.recuperoPago.cheques

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
object verDatos extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[models.recupero.Cheque,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:models.recupero.Cheque):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.recupero.recuperoPago.cheques.lineaCheque(linea,true))))}
    }
    
    def render(linea:models.recupero.Cheque): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((models.recupero.Cheque) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:35 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/recupero/recuperoPago/cheques/verDatos.scala.html
                    HASH: 161b8fc0940ff73dcbe02834e61a61f7fe3ca9e2
                    MATRIX: 823->1|947->31|986->36|998->41
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            