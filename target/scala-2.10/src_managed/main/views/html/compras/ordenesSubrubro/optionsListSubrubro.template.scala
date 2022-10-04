
package views.html.compras.ordenesSubrubro

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
object optionsListSubrubro extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[List[OrdenSubrubro],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(subRubro: List[OrdenSubrubro]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.33*/("""
<option value>Seleccionar</option>
"""),_display_(Seq[Any](/*3.2*/for(p <- subRubro) yield /*3.20*/ {_display_(Seq[Any](format.raw/*3.22*/("""<option value=""""),_display_(Seq[Any](/*3.38*/p/*3.39*/.id.toString)),format.raw/*3.51*/("""">"""),_display_(Seq[Any](/*3.54*/p/*3.55*/.nombre)),format.raw/*3.62*/("""</option>""")))})))}
    }
    
    def render(subRubro:List[OrdenSubrubro]): play.api.templates.HtmlFormat.Appendable = apply(subRubro)
    
    def f:((List[OrdenSubrubro]) => play.api.templates.HtmlFormat.Appendable) = (subRubro) => apply(subRubro)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Tue Oct 04 11:43:42 ART 2022
                    SOURCE: /home/marce/hspwork/play/sgpgit/sgp/app/views/compras/ordenesSubrubro/optionsListSubrubro.scala.html
                    HASH: 075319d033f23d6f584474a49145803a1b03ed16
                    MATRIX: 825->1|950->32|1023->71|1056->89|1095->91|1146->107|1155->108|1188->120|1226->123|1235->124|1263->131
                    LINES: 26->1|29->1|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3|31->3
                    -- GENERATED --
                */
            