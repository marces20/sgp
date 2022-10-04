
package views.html.presupuesto.lineaRecursoPresupuestario

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
object verLineaRecurso extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[LineaRecursoPresupuestario,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(linea:  LineaRecursoPresupuestario):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.38*/("""

"""),_display_(Seq[Any](/*3.2*/views/*3.7*/.html.presupuesto.lineaRecursoPresupuestario.lineaRecurso(linea, true))))}
    }
    
    def render(linea:LineaRecursoPresupuestario): play.api.templates.HtmlFormat.Appendable = apply(linea)
    
    def f:((LineaRecursoPresupuestario) => play.api.templates.HtmlFormat.Appendable) = (linea) => apply(linea)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/presupuesto/lineaRecursoPresupuestario/verLineaRecurso.scala.html
                    HASH: bcf21a4d8b70519d6c7705aee49012cec334f355
                    MATRIX: 843->1|973->37|1012->42|1024->47
                    LINES: 26->1|29->1|31->3|31->3
                    -- GENERATED --
                */
            