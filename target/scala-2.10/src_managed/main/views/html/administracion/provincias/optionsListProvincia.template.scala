
package views.html.administracion.provincias

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
object optionsListProvincia extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[Provincia],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(provincias: List[Provincia]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.31*/("""
<option value>Seleccionar</option>
"""),_display_(Seq[Any](/*3.2*/for(p <- provincias) yield /*3.22*/ {_display_(Seq[Any](format.raw/*3.24*/("""<option value=""""),_display_(Seq[Any](/*3.40*/p/*3.41*/.id.toString)),format.raw/*3.53*/("""">"""),_display_(Seq[Any](/*3.56*/p/*3.57*/.nombre)),format.raw/*3.64*/("""</option>""")))})))}
    }
    
    def render(provincias:List[Provincia]): play.api.templates.HtmlFormat.Appendable = apply(provincias)
    
    def f:((List[Provincia]) => play.api.templates.HtmlFormat.Appendable) = (provincias) => apply(provincias)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:37 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/administracion/provincias/optionsListProvincia.scala.html
                    HASH: 968ad0c04923a272dd90ed9330b6df08447a0813
                    MATRIX: 824->1|947->30|1020->69|1055->89|1094->91|1145->107|1154->108|1187->120|1225->123|1234->124|1262->131
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            